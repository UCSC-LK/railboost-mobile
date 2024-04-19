package org.ucsc.railboost_mobile.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import org.ucsc.railboost_mobile.api.LoginAPI
import org.ucsc.railboost_mobile.repository.LoginRepo
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideLoginRepo(loginAPI: LoginAPI): LoginRepo {
        return LoginRepo(loginAPI)
    }
}