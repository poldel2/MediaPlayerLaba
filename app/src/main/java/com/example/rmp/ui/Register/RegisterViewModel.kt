package com.example.rmp.ui.Register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rmp.R
import java.text.ParseException
import java.text.SimpleDateFormat

class RegisterViewModel : ViewModel() {

    private val _registerForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _registerForm

    fun registerDataChanged(login: String, name: String, password: String, confirmPassword: String, birthDay: String) {
        if (!isLoginValid(login)) {
            _registerForm.value = RegisterFormState(loginError = R.string.invalid_login)
        } else if (!isNameValid(name)) {
            _registerForm.value = RegisterFormState(nameError = R.string.invalid_name)
        } else if (!isDateOfBirthValid(birthDay)) {
            _registerForm.value = RegisterFormState(birthDayError = R.string.invalid_date_of_birth)
        } else if (!isPasswordValid(password)) {
            _registerForm.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else if (password != confirmPassword) {
            _registerForm.value = RegisterFormState(confirmPasswordError = R.string.passwords_do_not_match)
        } else {
            _registerForm.value = RegisterFormState(isDataValid = true)
        }
    }
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    private fun isLoginValid(login: String): Boolean {
        return login.length > 5
    }

    private fun isNameValid(name: String): Boolean {
        return name.isNotEmpty()
    }
    private fun isDateOfBirthValid(dateOfBirth: String): Boolean {
        val pattern = "dd.MM.yyyy"
        val dateFormat = SimpleDateFormat(pattern)
        dateFormat.isLenient = false
        return try {
            dateFormat.parse(dateOfBirth)
            true
        } catch (e: ParseException) {
            false
        }
    }
}
