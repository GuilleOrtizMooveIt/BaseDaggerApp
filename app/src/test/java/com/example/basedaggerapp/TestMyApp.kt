package com.example.basedaggerapp

import com.example.basedaggerapp.di.AppComponent
import com.example.basedaggerapp.di.MyApp

 class TestMyApp: MyApp() {
  override fun initializeDaggerComponent(): AppComponent {
    val component: TestAppComponent = DaggerTestAppComponent.factory()
      .create(this)
    component.inject(this)
    return component
  }
}