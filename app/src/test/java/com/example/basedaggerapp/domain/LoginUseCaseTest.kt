package com.example.basedaggerapp.domain

import com.example.basedaggerapp.di.DaggerTestAppComponent
import com.example.basedaggerapp.di.TestAppComponent
import com.example.basedaggerapp.di.TestMyApp
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class LoginUseCaseTest {

  @Before
  fun setUp() {
    val component: TestAppComponent = DaggerTestAppComponent.factory().create(TestMyApp())
    component.inject(this)
  }

  @Test
  fun login() {
  }
}