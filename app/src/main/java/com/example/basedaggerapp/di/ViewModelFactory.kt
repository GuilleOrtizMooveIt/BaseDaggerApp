package com.example.basedaggerapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basedaggerapp.MainActivity
import com.example.basedaggerapp.ui.main.MainFragment
import com.example.basedaggerapp.ui.main.MainViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor(
  private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
): ViewModelProvider.Factory {
  override fun <T: ViewModel> create(modelClass: Class<T>): T {
    val creator = creators[modelClass] ?: creators.entries.firstOrNull {
      modelClass.isAssignableFrom(it.key)
    }?.value ?: throw Error("unknown model class $modelClass")
    try {
      @Suppress("UNCHECKED_CAST")
      return creator.get() as T
    } catch (e: Exception) {
      throw Error(e)
    }
  }
}

@Module
abstract class ViewModelBuilderModule {
  @Binds
  abstract fun bindViewModelFactory(
    factory: ViewModelFactory
  ): ViewModelProvider.Factory
}

@Module
interface MainModule {
  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}

@Module
interface MainFragmentsBuilderModule {
  @ContributesAndroidInjector
  fun contributeMainFragment(): MainFragment
}

@Module
interface ActivityBuildersModule {
  @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentsBuilderModule::class])
  fun contributeMainActivity(): MainActivity
}

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)