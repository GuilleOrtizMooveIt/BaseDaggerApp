package com.example.basedaggerapp

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.example.basedaggerapp.di.TestMyApp

class CustomTestRunner : AndroidJUnitRunner() {
  override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
    return super.newApplication(cl, TestMyApp::class.java.name, context)
  }
}