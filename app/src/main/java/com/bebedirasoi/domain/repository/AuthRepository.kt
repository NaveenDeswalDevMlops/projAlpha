package com.bebedirasoi.domain.repository

import com.bebedirasoi.data.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUserId: String?
    suspend fun signIn(email: String, password: String): Result<Unit>
    suspend fun signUp(email: String, password: String, name: String): Result<Unit>
    suspend fun signOut()
    fun observeUser(userId: String): Flow<UserProfile?>
}
