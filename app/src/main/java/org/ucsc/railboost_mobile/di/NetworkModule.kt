package org.ucsc.railboost_mobile.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.ucsc.railboost_mobile.api.LoginAPI
import org.ucsc.railboost_mobile.api.RetrofitInstance
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

private const val BASE_URL = "http://10.0.2.2:8080/railboost_backend_war_exploded/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideLoginAPI(retrofit: Retrofit): LoginAPI {
        return retrofit.create(LoginAPI::class.java)
    }
}
