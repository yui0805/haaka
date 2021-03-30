package com.example.myapplication.util

object EventUtil {
    fun create_event_Json(uid2:String = "",date2:String, day2:String,deadline2:String,memo2:String,subject2:String,title2:String,url2:String):String
            ="{" +
            "  \"UID\": \"${uid2}\"," +
            "  \"DATE\": \"${date2}\"," +
            "  \"DAY\": \"${day2}\"," +
            "  \"START_TIME\": \"${deadline2}\"," +
            "  \"END_TIME\": \"${memo2}\"," +
            "  \"MEMO\": \"${subject2}\"," +
            "  \"PLACE\": \"${title2}\"," +
            "  \"TITLE\": \"${url2}\"" +
            "}"
}
}