package com.example.basedaggerapp.domain

import com.example.basedaggerapp.LocalTestMyApp
import com.example.basedaggerapp.di.DaggerLocalTestAppComponent
import org.junit.Before
import org.junit.Test

class LoginUseCaseTest {

  @Before
  fun setUp() {
    val component = DaggerLocalTestAppComponent.factory().create(LocalTestMyApp())
    component.inject(this)
  }

  @Test
  fun login() {
  }
}