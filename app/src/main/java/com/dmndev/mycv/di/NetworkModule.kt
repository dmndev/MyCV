package com.dmndev.mycv.di

import com.dmndev.mycv.model.repository.RestRepository
import com.google.gson.*
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.*

@Module
class NetworkModule {

    @Provides
    @Reusable
    internal fun provideApi(retrofit: Retrofit) : RestRepository {
        return retrofit.create(RestRepository::class.java)
    }

    @Provides
    @Reusable
    internal fun provideRetrofit(client : OkHttpClient, gson: Gson) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

    }

    @Provides
    internal fun getGson() : Gson {
        val builder = GsonBuilder().registerTypeAdapter(
            Date::class.java, object : JsonDeserializer<Date> {
                override fun deserialize(
                    json: JsonElement?,
                    typeOfT: Type?,
                    context: JsonDeserializationContext?
                ): Date {
                    return Date(json!!.asJsonPrimitive.asLong)
                }

            }
        )
        return builder.create()
    }

    @Provides
    internal fun getHttpClient(interceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    internal fun getHttpInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}