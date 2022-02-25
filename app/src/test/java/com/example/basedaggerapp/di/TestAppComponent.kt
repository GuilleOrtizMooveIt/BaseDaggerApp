package com.example.basedaggerapp.di

import android.content.Context
import com.example.basedaggerapp.ExampleUnitTest
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
interface TestAppComponent: AppComponent {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): TestAppComponent
  }

  fun inject(app: TestMyApp)
  fun inject(test: ExampleUnitTest)
}