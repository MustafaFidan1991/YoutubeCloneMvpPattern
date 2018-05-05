package com.mustafafidan.youtubeclonemvppattern.model

import com.mustafafidan.youtubeclonemvppattern.base.BaseModel

data class Response(var items : List<Video>) : BaseModel()