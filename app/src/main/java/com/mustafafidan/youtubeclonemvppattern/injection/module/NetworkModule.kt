package com.mustafafidan.youtubeclonemvppattern.injection.module


import com.mustafafidan.youtubeclonemvppattern.utils.BASE_URL
import com.mustafafidan.youtubeclonemvppattern.api.YoutubeApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@Suppress("unused")
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideYoutubeApi(retrofit: Retrofit): YoutubeApi {
        return retrofit.create(YoutubeApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideJsonConverter(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}