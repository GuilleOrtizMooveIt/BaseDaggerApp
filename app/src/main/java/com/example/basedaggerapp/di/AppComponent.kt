package com.example.basedaggerapp.di

import android.content.Context
import com.example.basedaggerapp.MainActivity
import com.example.basedaggerapp.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@Component(
  modules = [
    AndroidInjectionModule::class,
    ViewModelBuilderModule::class,
    ActivityBuildersModule::class,
    LoginModule::class
  ]
)
interface AppComponent: AndroidInjector<DaggerApplication> {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): AppComponent
  }

  fun inject(app: MyApp)
}