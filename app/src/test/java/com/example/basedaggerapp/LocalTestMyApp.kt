package com.example.basedaggerapp

import com.example.basedaggerapp.di.AppComponent
import com.example.basedaggerapp.di.DaggerLocalTestAppComponent
import com.example.basedaggerapp.di.LocalTestAppComponent
import com.example.basedaggerapp.di.MyApp

class LocalTestMyApp: MyApp() {
  override fun initializeDaggerComponent(): AppComponent {
    val component: LocalTestAppComponent = DaggerLocalTestAppComponent.factory().create(this)
    component.inject(this)
    return component
  }
}