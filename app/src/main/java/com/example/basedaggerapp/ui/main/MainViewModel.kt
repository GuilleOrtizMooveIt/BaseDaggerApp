package com.example.basedaggerapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.basedaggerapp.domain.LoginUsecase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val loginUsecase: LoginUsecase): ViewModel() {
  fun test(user: String, password: String): Boolean = loginUsecase.login(user, password)
}