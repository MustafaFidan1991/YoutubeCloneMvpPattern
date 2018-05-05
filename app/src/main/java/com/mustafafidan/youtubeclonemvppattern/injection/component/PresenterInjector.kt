package com.mustafafidan.youtubeclonemvppattern.injection.component

import com.mustafafidan.youtubeclonemvppattern.base.BaseView
import com.mustafafidan.youtubeclonemvppattern.injection.module.ContextModule
import com.mustafafidan.youtubeclonemvppattern.injection.module.NetworkModule
import com.mustafafidan.youtubeclonemvppattern.ui.home.HomePresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton



@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(homePresenter: HomePresenter)





    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder


        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}