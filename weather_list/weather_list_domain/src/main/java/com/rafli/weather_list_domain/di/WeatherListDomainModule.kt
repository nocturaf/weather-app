package com.rafli.weather_list_domain.di

import com.rafli.weather_list_domain.repository.WeatherListRepository
import com.rafli.weather_list_domain.use_case.GetWeatherByCityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object WeatherListDomainModule {

    @ViewModelScoped
    @Provides
    fun provideGetWeatherByCityUseCase(weatherListRepository: WeatherListRepository): GetWeatherByCityUseCase {
        return GetWeatherByCityUseCase(weatherListRepository)
    }
}