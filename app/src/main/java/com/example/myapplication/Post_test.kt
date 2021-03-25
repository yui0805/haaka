package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.POST
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.util.concurrent.TimeUnit

class Post_test : AppCompatActivity() {
    //Retrofit本体
    private val retrofit = Retrofit.Builder().apply {
        baseUrl("https://beginners-hack-demo2.herokuapp.com/mercy3")
    }.build()

    //サービスクラスの実装オブジェクト取得
    private val service = retrofit.create(MyService::class.java)

    val get = service.getRawResponseForPosts()

    // 通信全体で利用するMediaType
    private val mediaType: MediaType = MediaType.parse("application/json; charset=utf-8")!!

    private val myViewModel: MyViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MyViewModel::class.java)
    }

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_test)
    }

    fun onPostButtonClick(view: View) {
        if(!myViewModel.author.value.isNullOrBlank() && !myViewModel.title.value.isNullOrBlank()){
            val json = Util.creatJson(
                title = myViewModel.title.value!!,
                author = myViewModel.author.value!!
            )

            val requestBody = RequestBody.create(mediaType,json)

            val post = service.postRawRequestForPosts(requestBody)

            scope.launch {
                val responseBody = post.execute()

                responseBody.body()?.let{
                    myViewModel.result.postValue(it.toString())
                }
            }
        }
    }





}