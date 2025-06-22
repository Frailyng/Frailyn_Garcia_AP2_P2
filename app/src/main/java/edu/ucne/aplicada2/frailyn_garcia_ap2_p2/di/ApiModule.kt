package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.data.remote.RepositoryApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    const val BASE_URL = "https://api.github.com"

    @Provides
    @Singleton
    fun providesMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).add(DateAdapter())
            .build()

    @Provides
    @Singleton
    fun providesUsuariosApi(moshi: Moshi): RepositoryApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(RepositoryApi::class.java)
    }
}