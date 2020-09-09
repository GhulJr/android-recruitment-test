package dog.snow.androidrecruittest.di.module

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
class NetworkModule {
    
    @Provides
    @Singleton
    fun provideJacksonMapper(): ObjectMapper {
        return ObjectMapper()
    }

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024
        val httCacheDirectory = File(application.cacheDir, HTTP_CACHE_NAME)
        return Cache(httCacheDirectory, cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(mapper: ObjectMapper, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(httpClient)
            .build()
    }

    companion object {
        private const val HTTP_CACHE_NAME = "http-cache"
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

}