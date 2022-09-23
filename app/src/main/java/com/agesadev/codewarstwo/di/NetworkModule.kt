package com.agesadev.codewarstwo.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import com.agesadev.codewarstwo.BuildConfig
import com.agesadev.codewarstwo.data.remote.api.CodeWarsApi
import com.agesadev.codewarstwo.util.ConnectivityObserver
import com.agesadev.codewarstwo.util.ConnectivityObserver.*
import com.agesadev.codewarstwo.util.Utils.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() =
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient.Builder().build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(provideOkHttpClient())
            .build()

    }

    @Provides
    @Singleton
    fun provideCodeWarsApi(retrofit: Retrofit): CodeWarsApi {
        return retrofit.create(CodeWarsApi::class.java)
    }


    @Provides
    fun provideConnectivityObserver(context: Context): ConnectivityObserver {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return object : ConnectivityObserver {
            override fun observeConnectivity(): Flow<Status> {
                return callbackFlow {
                    val callBack = object : ConnectivityManager.NetworkCallback() {
                        override fun onAvailable(network: Network) {
                            super.onAvailable(network)
                            trySend(Status.CONNECTED).isSuccess
                        }

                        override fun onLost(network: Network) {
                            super.onLost(network)
                            trySend(Status.DISCONNECTED).isSuccess
                        }

                    }
                    connectivityManager.registerDefaultNetworkCallback(callBack)
                    awaitClose {
                        connectivityManager.unregisterNetworkCallback(callBack)
                    }
                }.distinctUntilChanged()

            }
        }
    }
}
