package com.example.basedaggerapp

import android.app.Instrumentation
import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.basedaggerapp.di.AppComponent
import com.example.basedaggerapp.di.DaggerTestAppComponent
import com.example.basedaggerapp.di.MyApp
import com.example.basedaggerapp.repository.FakeLoginRepository
import com.example.basedaggerapp.ui.main.MainFragment
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import javax.inject.Singleton

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
  @Test
  fun useAppContext() {
    // Context of the app under test.
    val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    assertEquals("com.example.basedaggerapp", appContext.packageName)
  }
}