package com.example.basedaggerapp.repository

import com.example.basedaggerapp.LoginRepository
import javax.inject.Inject

class FakeLoginRepository @Inject constructor(): LoginRepository {
  override fun logIn(user: String, password: String): Boolean {
    return true
  }
}