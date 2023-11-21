package com.example.bantest.di

import com.example.bantest.data.BanRepositoryImpl
import com.example.bantest.domain.repository.BanRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoyModule {

    @Binds
    abstract fun bindRepositoryScheduling(implementationClass: BanRepositoryImpl): BanRepository
}