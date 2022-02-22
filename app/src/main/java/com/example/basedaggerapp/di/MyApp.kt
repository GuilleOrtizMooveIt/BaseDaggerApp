package com.example.basedaggerapp.di

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class MyApp: DaggerApplication() {

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return initializeDaggerComponent()
  }

  open fun initializeDaggerComponent(): AppComponent {
    val component: AppComponent = DaggerAppComponent.factory().create(this)
    component.inject(this)
    return component
  }

  companion object {
    @JvmStatic
    lateinit var context: MyApp
      internal set
  }
}