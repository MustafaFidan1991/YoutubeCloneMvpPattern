package com.mustafafidan.youtubeclonemvppattern.model

import com.mustafafidan.youtubeclonemvppattern.base.BaseModel

data class Snippet(val channelTitle:String, val publishedAt:String,val title:String,val thumbnails: Thumbnails) :BaseModel()