package com.example.basedaggerapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.basedaggerapp.domain.LoginUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {
  fun test(user: String, password: String): Boolean = loginUseCase.login(user, password)
}