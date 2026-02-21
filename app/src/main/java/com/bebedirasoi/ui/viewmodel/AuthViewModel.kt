package com.bebedirasoi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bebedirasoi.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun signIn(email: String, password: String) = viewModelScope.launch {
        _uiState.value = _uiState.value.copy(loading = true, error = null)
        authRepository.signIn(email, password)
            .onSuccess { _uiState.value = _uiState.value.copy(loading = false, isLoggedIn = true) }
            .onFailure { _uiState.value = _uiState.value.copy(loading = false, error = it.message) }
    }

    fun signUp(name: String, email: String, password: String) = viewModelScope.launch {
        _uiState.value = _uiState.value.copy(loading = true, error = null)
        authRepository.signUp(email, password, name)
            .onSuccess { _uiState.value = _uiState.value.copy(loading = false, isLoggedIn = true) }
            .onFailure { _uiState.value = _uiState.value.copy(loading = false, error = it.message) }
    }
}

data class AuthUiState(
    val loading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val error: String? = null
)
