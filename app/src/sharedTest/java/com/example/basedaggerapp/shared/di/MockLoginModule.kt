package com.example.basedaggerapp.shared.di

import com.example.basedaggerapp.LoginRepository
import com.example.basedaggerapp.shared.repository.FakeLoginRepository
import dagger.Binds
import dagger.Module

@Module
abstract class MockLoginModule {
  @Binds
  abstract fun getRepo(repo: FakeLoginRepository): LoginRepository
}