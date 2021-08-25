package com.luismiguel.mock.di

import android.content.SharedPreferences
import com.luismiguel.mock.api.IApiService
import com.luismiguel.mock.main.IMain
import com.luismiguel.mock.main.MainImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @AppScope
    @RetrofitAnnotation
    fun retrofit1(): Retrofit {
        var loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(
            HttpLoggingInterceptor.Level.BODY)
        val okBuilder = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl("http://demo2484970.mockable.io/")
            .client(okBuilder)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    fun iApiService(@RetrofitAnnotation retrofit: Retrofit): IApiService = retrofit.create(IApiService::class.java)

    @Provides
    @AppScope
    fun iMain(apiService: IApiService): IMain = MainImpl(apiService)
}