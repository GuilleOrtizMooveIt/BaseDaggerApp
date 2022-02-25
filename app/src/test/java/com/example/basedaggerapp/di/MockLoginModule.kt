package com.example.basedaggerapp.di

import com.example.basedaggerapp.LoginRepository
import com.example.basedaggerapp.repository.FakeLoginRepository
import dagger.Binds
import dagger.Module

@Module
abstract class MockLoginModule {
  @Binds
  abstract fun getRepo(repo: FakeLoginRepository): LoginRepository
}