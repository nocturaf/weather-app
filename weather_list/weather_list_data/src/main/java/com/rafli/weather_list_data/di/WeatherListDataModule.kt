package com.rafli.weather_list_data.di

import com.rafli.weather_list_data.remote.WeatherListAPI
import com.rafli.weather_list_data.repository.WeatherListRepositoryImpl
import com.rafli.weather_list_domain.repository.WeatherListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherListDataModule {

    @Provides
    @Singleton
    fun provideWeatherListApi(retrofit: Retrofit): WeatherListAPI {
        return retrofit.create(WeatherListAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherListRepository(api: WeatherListAPI): WeatherListRepository {
        return WeatherListRepositoryImpl(api)
    }
}