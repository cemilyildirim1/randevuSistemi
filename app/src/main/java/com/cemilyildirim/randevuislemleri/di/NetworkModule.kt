package com.cemilyildirim.randevuislemleri.di

import com.cemilyildirim.randevuislemleri.view.service.DataAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }
    @Singleton
    @Provides
    fun provideRetrofit(client : OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    @Singleton
    @Provides
    fun provideDataAPI(retrofit: Retrofit): DataAPI{
        return retrofit.create(DataAPI::class.java)
    }
}