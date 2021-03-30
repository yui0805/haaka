package com.example.myapplication

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Myservice_event
{
    @GET("mercy4")
    fun getRawResponseForPosts2(): Call<ResponseBody>
    @POST("upload_event")
    fun postRawRequestForPosts2(@Body body: RequestBody): Call<ResponseBody>
    @PUT("posts/{id}")
    fun putRawRequestForPosts2(@Path("id") id:String, @Body body: RequestBody): Call<ResponseBody>
    @DELETE("posts/{id}")
    fun deletePathParam2(@Path("id") id:String ): Call<ResponseBody>
}