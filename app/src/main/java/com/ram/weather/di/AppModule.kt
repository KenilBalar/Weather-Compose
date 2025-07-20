package com.ram.weather.di

import com.ram.weather.data.remote.WeatherApi
import com.ram.weather.data.repository.WeatherRepository
import com.ram.weather.data.repository.WeatherRepositoryImpl
import com.ram.weather.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * @author ASUS
 * @date 21-07-2025
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}
