package com.tsfrsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScopeHilt

@Module
@InstallIn(SingletonComponent::class)
object coroutineModule{
    @Provides
    @Singleton
    @IoDispatcher
    fun provideIoDis() : CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    @DefaultDispatcher
    fun provideDefaultDispatcher() : CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Singleton
    @AppScopeHilt
    fun provideAppScopeHilt(@DefaultDispatcher dd: CoroutineDispatcher) : CoroutineScope = CoroutineScope(
        SupervisorJob() + dd
    )
}