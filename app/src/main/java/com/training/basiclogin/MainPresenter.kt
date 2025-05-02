package com.training.basiclogin

import androidx.lifecycle.MutableLiveData

class MainPresenter {
    private val _uiState = MutableLiveData<MainUIState>(MainUIState.None)
    private val MIN_LENGHT = 8
    private val EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"

    fun onInit() {
        _uiState.postValue(MainUIState.Loading)
        try {
            //TODO
        } catch (err: Throwable) {
            err.printStackTrace()
            _uiState.postValue(MainUIState.Error("Error onInit"))
        }
    }

    fun validateLogin(user: String, password: String): Boolean {
        if (isValidEmail(user) && isValidLength(password)) {
            _uiState.value = MainUIState.Loading
            return true
        }
        return false
    }

    fun isValidEmail(email: String): Boolean {
        return EMAIL_REGEX.toRegex().matches(email)
    }

    fun isValidLength(password: String): Boolean {
        return password.length >= MIN_LENGHT
    }
}

sealed class MainUIState {
    object None : MainUIState()
    object Loading : MainUIState()
    data class Error(val message: String): MainUIState()
}