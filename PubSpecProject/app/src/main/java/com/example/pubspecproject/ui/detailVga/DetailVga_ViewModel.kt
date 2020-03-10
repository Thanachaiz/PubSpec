package com.example.pubspecproject.ui.detailVga

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.pubspecproject.model.VgaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.ViewModel
import com.example.pubspecproject.`interface`.onClickVgaItem
import com.example.pubspecproject.api.Vga_Req.getVga.vgaReq_Api


class DetailVga_ViewModel: ViewModel(){

    private var _listResult = MutableLiveData<ArrayList<VgaModel>>()

    init {
        callGetApiVga()
    }

    private fun callGetApiVga() {

        vgaReq_Api.groupListVga().enqueue(object : Callback<ArrayList<VgaModel>> {

            override fun onResponse(call: Call<ArrayList<VgaModel>>, response: Response<ArrayList<VgaModel>>) {
                val listData = response.body()
                if (response.isSuccessful){
                    val filterData = listData?.filter { vgaModel ->
                        !vgaModel.adv_id.isNullOrEmpty() && vgaModel.vga_price_adv != 0
                    }
                    val data : ArrayList<VgaModel> = (filterData as ArrayList<VgaModel>)
                    _listResult.value = data
                }
                else{
                    Log.e("ErrorBodyVgaCall", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<VgaModel>>, t: Throwable) {
                Log.e("Error","${t.printStackTrace()}")
            }
        })
    }

    fun getAllVga(): LiveData<ArrayList<VgaModel>>? {
        if (_listResult == null){
            _listResult = MutableLiveData()
        }
        return _listResult
    }

//    fun getFilteredList(strEditText: String): LiveData<ArrayList<VgaModel>> {
//        return Transformations.switchMap(userListLiveData) {
//            it.filter {
//                it.name.contains(strEditText)
//            }
//        }
//    }
}