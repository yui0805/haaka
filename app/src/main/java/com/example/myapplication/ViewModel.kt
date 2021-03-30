package com.example.myapplication

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class MainViewModel: BaseObservable() {

    var messageEditText: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.messageLength)
        }

    @Bindable
    var messageLength: String = "0"
        get() = "${messageEditText.length}"
}
