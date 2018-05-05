package com.mustafafidan.youtubeclonemvppattern.ui.home

import com.mustafafidan.youtubeclonemvppattern.base.BaseView
import com.mustafafidan.youtubeclonemvppattern.model.Video

interface HomeView : BaseView {
    fun setVideos(videList : List<Video>)


    fun showLoading()


    fun hideLoading()
}