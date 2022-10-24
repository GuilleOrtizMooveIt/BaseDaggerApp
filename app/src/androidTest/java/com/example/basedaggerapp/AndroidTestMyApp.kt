package com.example.basedaggerapp

import com.example.basedaggerapp.di.AppComponent
import com.example.basedaggerapp.di.DaggerAndroidTestAppComponent
import com.example.basedaggerapp.di.MyApp

class AndroidTestMyApp: MyApp() {
  override fun initializeDaggerComponent(): AppComponent {
    val component = DaggerAndroidTestAppComponent.factory().create(this)
    component.inject(this)
    return component
  }
}