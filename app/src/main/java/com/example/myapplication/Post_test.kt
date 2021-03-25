package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_post_test.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Retrofit

class Post_test : AppCompatActivity() {
    //Retrofit本体
    private val retrofit = Retrofit.Builder().apply {
        baseUrl("https://beginners-hack-demo2.herokuapp.com/")
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
        val binding: Post_test =
            DataBindingUtil.setContentView(this,R.layout.activity_post_test)

        binding.sample = SampleBindingData("sample")


        onPostButtonClick(edittext)



    }

    fun onPostButtonClick(view: View?) {
        if(!myViewModel.author.value.isNullOrBlank() && !myViewModel.title.value.isNullOrBlank()){
            val json = Util.creatJson(
                title = myViewModel.title.value!!,
                author = myViewModel.author.value!!
            )

            val requestBody = RequestBody.create(mediaType,json)

            val data = Post(title = myViewModel.title.value!!,author = myViewModel.author.value!!)

            val post = service.postRawRequestForPosts(data)

            scope.launch {
                val responseBody = post.execute()

                responseBody.body()?.let{
                    myViewModel.result.postValue(it.toString())
                }
            }
        }

    }

    /**
     * PUTボタンが押された時の処理
     *
     * @param view
     */
    fun onPutButtonClick(view: View) {

        if ((!myViewModel.id.value.isNullOrBlank()
                        && !myViewModel.title.value.isNullOrBlank()
                        && !myViewModel.author.value.isNullOrBlank())
        ) {

            val json = Util.creatJson(
                    id = myViewModel.id.value!!.toString(),
                    title = myViewModel.title.value!!.toString(),
                    author = myViewModel.author.value!!.toString()
            )

            val requestBody = RequestBody.create(mediaType, json)

            val put = service.putRawRequestForPosts(myViewModel.id.value!!.toString(), requestBody)

            scope.launch {
                val responseBody = put.execute()

                responseBody.body()?.let {

                    myViewModel.result.postValue(it.toString())

                }
            }
        }

    }

    /**
     * DELETEボタンが押された時の処理
     *
     * @param view
     */
    fun onDeleteButtonClick(view: View) {


        if (!myViewModel.id.value.isNullOrBlank()) {

            val delete = service.deletePathParam(myViewModel.id.value!!)

            scope.launch {

                if (delete.execute().isSuccessful) {
                    withContext(Dispatchers.Main) {

                        Toast.makeText(this@Post_test, "削除成功", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    /**
     * GETボタンが押された時の処理
     *
     * @param view
     */
    fun onGetButtonClick(view: View) {


        val get = service.getRawResponseForPosts()

        scope.launch {

            val responseBody = get.execute()

            responseBody.body()?.let {

                myViewModel.result.postValue(it.string())

            }
        }
    }








}