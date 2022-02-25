package com.example.basedaggerapp

import android.os.Build
import com.example.basedaggerapp.di.DaggerTestAppComponent
import com.example.basedaggerapp.di.MyApp
import com.example.basedaggerapp.di.TestAppComponent
import com.example.basedaggerapp.di.TestMyApp
import com.example.basedaggerapp.repository.FakeLoginRepository
import com.example.basedaggerapp.repository.RealRepository
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
@Config(
  application = MyApp::class,
  sdk = [Build.VERSION_CODES.O_MR1]
)
class ExampleUnitTest {

  @Inject
  lateinit var loginRepository: LoginRepository

  @Inject
  lateinit var realRepository: RealRepository

  @Inject
  lateinit var fakeRepository: FakeLoginRepository

  private lateinit var activity: MainActivity

  private lateinit var activityController: ActivityController<MainActivity>

  @Before
  fun setup() {
    val component: TestAppComponent = DaggerTestAppComponent.factory().create(TestMyApp())
    component.inject(this)
  }

  @Test
  fun useMockLoginRepo_LoginSuccess() {
    assertEquals(true, fakeRepository.logIn(USER, PASSWORD))
  }
  @Test
  fun useMockLoginRepo_invalidCredentials_LoginSuccess() {
    assertEquals(true, fakeRepository.logIn(INVALID_USER, INVALID_PASSWORD))
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
    const val USER = "user"
    const val PASSWORD = "password"
    const val INVALID_USER = ""
    const val INVALID_PASSWORD = ""
  }
}