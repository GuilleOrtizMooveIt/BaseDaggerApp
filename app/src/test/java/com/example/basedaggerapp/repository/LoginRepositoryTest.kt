package com.example.basedaggerapp.repository

import com.example.basedaggerapp.LoginRepository
import com.example.basedaggerapp.di.DaggerTestAppComponent
import com.example.basedaggerapp.di.TestAppComponent
import com.example.basedaggerapp.di.TestMyApp
import com.example.basedaggerapp.repository.RealRepository.Companion.PASSWORD
import com.example.basedaggerapp.repository.RealRepository.Companion.USER
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import javax.inject.Inject

class LoginRepositoryTest {

  @Inject
  lateinit var loginRepository: LoginRepository

  @Inject
  lateinit var realRepository: RealRepository

  @Before
  fun setup() {
    val component: TestAppComponent = DaggerTestAppComponent.factory().create(TestMyApp())
    component.inject(this)
  }

  @Test
  fun useMockLoginRepo_LoginSuccess() {
    assertEquals(true, loginRepository.logIn(USER, PASSWORD))
  }

  @Test
  fun useMockLoginRepo_invalidCredentials_LoginSuccess() {
    assertEquals(false, loginRepository.logIn(INVALID_USER, INVALID_PASSWORD))
  }

  @Test
  fun useLoginRepo_validCrededentials_LoginSuccess() {
    assertEquals(true, realRepository.logIn(USER, PASSWORD))
  }

  @Test
  fun useLoginRepo_invalidCrededentials_LoginError() {
    assertEquals(false, realRepository.logIn(INVALID_USER, INVALID_PASSWORD))
  }

  companion object {
    const val INVALID_USER = ""
    const val INVALID_PASSWORD = ""
  }
}