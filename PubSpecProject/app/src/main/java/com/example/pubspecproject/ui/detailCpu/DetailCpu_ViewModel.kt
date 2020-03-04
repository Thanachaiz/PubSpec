package com.example.pubspecproject.ui.detailCpu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pubspecproject.api.Cpu_Req.getCpu.cpuReq_Api
import com.example.pubspecproject.model.CpuModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCpu_ViewModel : ViewModel(){

    private var _listResult = MutableLiveData<ArrayList<CpuModel>>()

    init {
        callGetApiCpu()
    }

    private fun callGetApiCpu() {

        cpuReq_Api.groupListCpu().enqueue(object : Callback<ArrayList<CpuModel>> {

            override fun onResponse(call: Call<ArrayList<CpuModel>>, response: Response<ArrayList<CpuModel>>) {
                val listData = response.body()
                if (response.isSuccessful){
                    val filterData = listData?.filter { cpuModel ->
                        !cpuModel.adv_id.isNullOrEmpty() && cpuModel.cpu_price_adv != 0
                    }
                    val data : ArrayList<CpuModel> = (filterData as ArrayList<CpuModel>)

                    _listResult.value = data
                }
                else{
                    Log.e("ErrorBodyCpuCall", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<CpuModel>>, t: Throwable) {
                Log.e("Error","${t.printStackTrace()}")
            }
        })
    }

    fun getAllCpu(): LiveData<ArrayList<CpuModel>>? {
        if (_listResult == null){
            _listResult = MutableLiveData()
        }
        return _listResult
    }
}