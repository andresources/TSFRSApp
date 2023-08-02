package com.tsfrsapp.utils

sealed class UiState<out T>{
    object Loading : UiState<Nothing>()
    data class Success<T>(var data: T) : UiState<T>()
    data class Error(var msg: String) : UiState<Nothing>()
}