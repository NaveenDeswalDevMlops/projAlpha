package com.bebedirasoi.di

import com.bebedirasoi.data.repository.FirebaseAuthRepository
import com.bebedirasoi.data.repository.FirebaseMealRepository
import com.bebedirasoi.data.repository.FirebaseOrderRepository
import com.bebedirasoi.domain.repository.AuthRepository
import com.bebedirasoi.domain.repository.MealRepository
import com.bebedirasoi.domain.repository.OrderRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAuthRepository(impl: FirebaseAuthRepository): AuthRepository

    @Binds
    abstract fun bindMealRepository(impl: FirebaseMealRepository): MealRepository

    @Binds
    abstract fun bindOrderRepository(impl: FirebaseOrderRepository): OrderRepository
}
