package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(
    var id:MutableLiveData<String> = MutableLiveData(""),
    var title:MutableLiveData<String> = MutableLiveData<String>(""),
    var author:MutableLiveData<String> = MutableLiveData<String>(""),
    var result:MutableLiveData<String> = MutableLiveData<String>("")
) : ViewModel()