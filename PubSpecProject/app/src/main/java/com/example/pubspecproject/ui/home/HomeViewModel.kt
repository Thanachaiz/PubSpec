package com.example.pubspecproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pubspecproject.model.ItemListModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<MutableList<ItemListModel>>().apply {
        value = mutableListOf<ItemListModel>(ItemListModel("CPU : Intel Core I9"))
    }
    val text: LiveData<MutableList<ItemListModel>> = _text
}