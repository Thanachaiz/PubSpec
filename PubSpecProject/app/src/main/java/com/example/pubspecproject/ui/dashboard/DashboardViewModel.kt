package com.example.pubspecproject.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        if (value != null){
            value = "This is dashboard Fragment"
        }else{
            value = "111234"
        }
    }
    val text: LiveData<String> = _text
}