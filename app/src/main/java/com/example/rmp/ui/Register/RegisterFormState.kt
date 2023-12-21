package com.example.rmp.ui.Register

data class RegisterFormState(
    val loginError: Int? = null,
    val nameError: Int? = null,
    val passwordError: Int? = null,
    val confirmPasswordError: Int? = null,
    val birthDayError: Int? = null,
    val isDataValid: Boolean = false
)
