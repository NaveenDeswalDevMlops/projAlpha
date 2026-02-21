package com.bebedirasoi.data.repository

import com.bebedirasoi.data.model.Meal
import com.bebedirasoi.data.model.Order
import com.bebedirasoi.data.model.UserProfile
import com.bebedirasoi.domain.repository.AuthRepository
import com.bebedirasoi.domain.repository.MealRepository
import com.bebedirasoi.domain.repository.OrderRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseAuthRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {
    override val currentUserId: String?
        get() = auth.currentUser?.uid

    override suspend fun signIn(email: String, password: String): Result<Unit> = runCatching {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun signUp(email: String, password: String, name: String): Result<Unit> = runCatching {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        val uid = result.user?.uid.orEmpty()
        firestore.collection("users").document(uid).set(
            UserProfile(id = uid, name = name, email = email)
        ).await()
    }

    override suspend fun signOut() {
        auth.signOut()
    }

    override fun observeUser(userId: String): Flow<UserProfile?> = callbackFlow {
        val registration = firestore.collection("users").document(userId)
            .addSnapshotListener { snapshot, _ ->
                trySend(snapshot?.toObject(UserProfile::class.java))
            }
        awaitClose { registration.remove() }
    }
}

@Singleton
class FirebaseMealRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) : MealRepository {
    override fun getMeals(): Flow<List<Meal>> = callbackFlow {
        val registration = firestore.collection("meals")
            .addSnapshotListener { snapshot, _ ->
                val data = snapshot?.documents?.mapNotNull { doc ->
                    doc.toObject(Meal::class.java)?.copy(id = doc.id)
                }.orEmpty()
                trySend(data)
            }
        awaitClose { registration.remove() }
    }

    override suspend fun upsertMeal(meal: Meal): Result<Unit> = runCatching {
        val target = if (meal.id.isBlank()) firestore.collection("meals").document()
        else firestore.collection("meals").document(meal.id)
        target.set(meal.copy(id = target.id)).await()
    }

    override suspend fun deleteMeal(mealId: String): Result<Unit> = runCatching {
        firestore.collection("meals").document(mealId).delete().await()
    }
}

@Singleton
class FirebaseOrderRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) : OrderRepository {
    override fun getOrdersForUser(userId: String): Flow<List<Order>> = callbackFlow {
        val reg = firestore.collection("orders").whereEqualTo("userId", userId)
            .addSnapshotListener { snapshot, _ ->
                val orders = snapshot?.documents?.mapNotNull { it.toObject(Order::class.java)?.copy(id = it.id) }.orEmpty()
                trySend(orders)
            }
        awaitClose { reg.remove() }
    }

    override fun getAllOrders(): Flow<List<Order>> = callbackFlow {
        val reg = firestore.collection("orders").addSnapshotListener { snapshot, _ ->
            val orders = snapshot?.documents?.mapNotNull { it.toObject(Order::class.java)?.copy(id = it.id) }.orEmpty()
            trySend(orders)
        }
        awaitClose { reg.remove() }
    }

    override suspend fun placeOrder(order: Order): Result<String> = runCatching {
        val ref = firestore.collection("orders").document()
        ref.set(order.copy(id = ref.id)).await()
        ref.id
    }

    override suspend fun updateStatus(orderId: String, status: String): Result<Unit> = runCatching {
        firestore.collection("orders").document(orderId).update("status", status).await()
    }
}
