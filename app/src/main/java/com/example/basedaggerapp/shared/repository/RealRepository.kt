package com.example.basedaggerapp.shared.repository

import com.example.basedaggerapp.LoginRepository
import javax.inject.Inject

class RealRepository @Inject constructor(): LoginRepository {
  override fun logIn(user: String, password: String): Boolean {
    return user == USER && password == PASSWORD
  }

  companion object {
    const val USER = "user"
    const val PASSWORD = "password"
  }
}