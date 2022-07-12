package com.example.basedaggerapp.di

import android.content.Context
import com.example.basedaggerapp.AndroidTestMyApp
import com.example.basedaggerapp.ExampleInstrumentedTest
import com.example.basedaggerapp.shared.di.MockLoginModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
  modules = [
    AndroidInjectionModule::class,
    ViewModelBuilderModule::class,
    ActivityBuildersModule::class,
//    LoginModule::class]
    MockLoginModule::class]
)
interface AndroidTestAppComponent: AppComponent {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): AndroidTestAppComponent
  }

  fun inject(app: AndroidTestMyApp)
  fun inject(test: ExampleInstrumentedTest)
}