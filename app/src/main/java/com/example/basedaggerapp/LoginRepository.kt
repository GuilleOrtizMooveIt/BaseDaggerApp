package com.example.basedaggerapp

interface LoginRepository {
  fun logIn(user: String, password: String): Boolean
}