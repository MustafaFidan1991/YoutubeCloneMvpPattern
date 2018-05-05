package com.mustafafidan.youtubeclonemvppattern.base

import com.mustafafidan.youtubeclonemvppattern.injection.component.DaggerPresenterInjector
import com.mustafafidan.youtubeclonemvppattern.injection.component.PresenterInjector
import com.mustafafidan.youtubeclonemvppattern.injection.module.*
import com.mustafafidan.youtubeclonemvppattern.ui.home.HomePresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }


    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when (this) {
            is HomePresenter -> injector.inject(this)




        }
    }

}