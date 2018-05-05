package com.mustafafidan.youtubeclonemvppattern.model

import com.mustafafidan.youtubeclonemvppattern.base.BaseModel
import com.squareup.moshi.Json

data class Video(val snippet: Snippet) : BaseModel()