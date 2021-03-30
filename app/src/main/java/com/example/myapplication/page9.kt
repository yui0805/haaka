package com.example.myapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_page9.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.MediaType
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class page9 : AppCompatActivity() {


    // Retrofit本体
    private val retrofit = Retrofit.Builder().apply {
        baseUrl("https://hakadorikun.herokuapp.com/")
    }.build()
    // サービスクラスの実装オブジェクト取得
    private val service = retrofit.create(Myservice_event::class.java)
    // 通信全体で利用するMediaType
    private val mediaType: MediaType = MediaType.parse("application/json; charset=utf-8")!!
    private val myViewModel: MyViewModel_event by lazy {
        ViewModelProvider.NewInstanceFactory().create(MyViewModel_event::class.java)
    }
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.model = myViewModel
        binding.lifecycleOwner = this









    }


}