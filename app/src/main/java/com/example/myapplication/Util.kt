package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

object Util{
    fun creatJson(id:String = "",title:String,author:String):String
            ="{" +
            "  \"id\": \"${id}\"," +
            "  \"title\": \"${title}\"," +
            "  \"author\": \"${author}\"" +
            "}"
}