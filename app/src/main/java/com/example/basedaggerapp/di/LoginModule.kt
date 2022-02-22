package com.example.basedaggerapp.di

import com.example.basedaggerapp.LoginRepository
import com.example.basedaggerapp.repository.RealRepository
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {
  @Binds
  abstract fun getRepo(repo: RealRepository): LoginRepository
}