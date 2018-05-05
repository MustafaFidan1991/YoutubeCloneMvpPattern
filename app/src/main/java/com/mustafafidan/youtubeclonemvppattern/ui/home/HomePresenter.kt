package com.mustafafidan.youtubeclonemvppattern.ui.home

import android.util.Log
import com.mustafafidan.youtubeclonemvppattern.api.YoutubeApi
import com.mustafafidan.youtubeclonemvppattern.base.BasePresenter
import com.mustafafidan.youtubeclonemvppattern.model.SearchDto
import com.mustafafidan.youtubeclonemvppattern.utils.YOUTUBE_API_KEY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter(homeView: HomeView) : BasePresenter<HomeView>(homeView) {



    @Inject
    lateinit var youtubeApi: YoutubeApi

    private var subscription: Disposable? = null


    fun getVideos(){
        view.showLoading()
        subscription = youtubeApi.
                search(SearchDto("snippet","fun", YOUTUBE_API_KEY,"25").toMap())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate {
                    view.hideLoading() }
                .subscribe(
                        {
                            response ->
                            view.setVideos(response.items)

                        },
                        {
                            // todo error profile bilgileri
                            Log.d("","")
                        }
                )
    }





    override fun onViewCreated() {
    }



    override fun onViewDestroyed() {
        subscription?.dispose()
    }

}