package com.example.basedaggerapp.domain

import com.example.basedaggerapp.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
  private val repository: LoginRepository
) {
  fun login(user: String, password: String): Boolean {
    return repository.logIn(user, password)
  }
}