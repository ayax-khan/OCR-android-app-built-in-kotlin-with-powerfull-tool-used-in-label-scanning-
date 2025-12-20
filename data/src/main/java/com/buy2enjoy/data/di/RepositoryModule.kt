package com.buy2enjoy.data.di

import com.buy2enjoy.data.repository.ReturnRepositoryImpl
import com.buy2enjoy.domain.repository.ReturnRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindReturnRepository(impl: ReturnRepositoryImpl): ReturnRepository
}
