package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel_event
    (
    var uid2: MutableLiveData<String> = MutableLiveData<String>(""),
    var date2:MutableLiveData<String> = MutableLiveData<String>(""),
    var day2:MutableLiveData<String> = MutableLiveData<String>(""),
    var deadline2:MutableLiveData<String> = MutableLiveData<String>(""),
    var memo2:MutableLiveData<String> = MutableLiveData<String>(""),
    var subject2:MutableLiveData<String> = MutableLiveData<String>(""),
    var title2:MutableLiveData<String> = MutableLiveData<String>(""),
    var url2:MutableLiveData<String> = MutableLiveData<String>(""),
    var result2:MutableLiveData<String> = MutableLiveData<String>(""),
    var id2:MutableLiveData<String> = MutableLiveData<String>("")
    ) : ViewModel()

