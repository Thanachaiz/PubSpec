package com.example.pubspecproject.ui.detailVga

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pubspecproject.model.VgaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.ViewModel
import com.example.pubspecproject.api.Vga_Req.getVga.vgaReq_Api


class DetailViewModel: ViewModel(){

    private var listResult = MutableLiveData<ArrayList<VgaModel>>().apply {
        this.also {
            callGetApiVga()
        }
    }

    private fun callGetApiVga() {

        vgaReq_Api.groupListVga().enqueue(object : Callback<ArrayList<VgaModel>> {

            override fun onResponse(call: Call<ArrayList<VgaModel>>, response: Response<ArrayList<VgaModel>>) {
                Log.d("DataSet",response.body().toString())
                if (response.isSuccessful){
                    val data : ArrayList<VgaModel> = (response.body() as ArrayList<VgaModel>?)!!
                    listResult.value = data
//                    print(result)
//                    initDataSet(listResult)
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
        if (listResult == null){
            listResult = MutableLiveData()
        }
        return listResult
    }
}