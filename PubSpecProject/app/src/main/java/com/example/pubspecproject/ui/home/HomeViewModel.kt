package com.example.pubspecproject.ui.home

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pubspecproject.model.CpuBuild
import com.example.pubspecproject.model.ItemBuildModel
import com.example.pubspecproject.model.VgaBuild

class HomeViewModel : ViewModel() {


    private var hashMap = HashMap<String, Int?>()
    private var _listPrice = MutableLiveData<HashMap<String, Int?>>()
    private var _resultCpu = MutableLiveData<CpuBuild>()
    private var _resultVga = MutableLiveData<VgaBuild>()
//    private val _priceCpu = MutableLiveData<Int>()
//    private val _nameCpu = MutableLiveData<String>()
//    private val _nameCpu = MutableLiveData<String>()
//    private val _nameCpu = MutableLiveData<String>()

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                val resultCpu = CpuBuild(
                    data?.getStringExtra("name_cpu"),
                    data?.getStringExtra("image_cpu"),
                    data?.getIntExtra("price_cpu", 0)
                )

                hashMap["priceCpu"] = data?.getIntExtra("price_cpu", 0)

                _resultCpu.value = resultCpu
                _listPrice.value = hashMap

            }
            if (resultCode == RESULT_CANCELED) {
                //NOTHING
            }
        }
        if (requestCode == 2) {

            if (resultCode == RESULT_OK) {
                val resultVga = VgaBuild(
                    data?.getStringExtra("name_vga"),
                    data?.getStringExtra("image_vga"),
                    data?.getIntExtra("price_vga", 0)
                )

                hashMap["priceVga"] = data?.getIntExtra("price_vga", 0)

                _resultVga.value = resultVga
                _listPrice.value = hashMap
            }
            if (resultCode == RESULT_CANCELED) {
                //NOTHING
            }
        }
    }

    fun updateBuildCpu() : LiveData<CpuBuild>{

        if (_resultCpu == null){
            _resultCpu = MutableLiveData()
        }

        return _resultCpu
    }

    fun updateBuildVga() : LiveData<VgaBuild>{

        if (_resultVga == null){
            _resultVga = MutableLiveData()
        }

        return _resultVga
    }

    fun callTotalPrice(): LiveData<HashMap<String, Int?>>{

        if (_listPrice == null){
            _listPrice = MutableLiveData()
        }
        return _listPrice
    }
}