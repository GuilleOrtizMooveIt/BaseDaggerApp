package com.example.basedaggerapp.repository

import com.example.basedaggerapp.LoginRepository
import javax.inject.Inject

class RealRepository @Inject constructor(): LoginRepository {
  override fun logIn(user: String, password: String): Boolean {
    return user == "user" && password == "password"
  }
}