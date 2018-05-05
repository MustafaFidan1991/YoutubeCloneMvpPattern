package com.mustafafidan.youtubeclonemvppattern.model

class SearchDto(val part : String = "snippet",val q:String,val key :String,val maxResults:String){

    fun toMap():HashMap<String,String>{
        var map = hashMapOf<String,String>()

        map.put("part",part)
        map.put("q",q)
        map.put("key",key)
        map.put("maxResults",maxResults)

        return map
    }
}