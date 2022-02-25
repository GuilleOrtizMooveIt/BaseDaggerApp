package com.example.basedaggerapp.di

class TestMyApp: MyApp() {
  override fun initializeDaggerComponent(): AppComponent {
    val component: TestAppComponent = DaggerTestAppComponent.factory()
      .create(this)
    component.inject(this)
    return component
  }
}