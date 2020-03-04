package com.example.pubspecproject.api

import androidx.lifecycle.MutableLiveData
import com.example.pubspecproject.model.CpuModel
import com.example.pubspecproject.model.VgaModel
import retrofit2.Call
import retrofit2.http.GET

interface Cpu_Req {

    @GET("cpu")
    fun groupListCpu(): Call<ArrayList<CpuModel>>

    object getCpu{

        val BASE_URL = "https://www.advice.co.th/pc/get_comp/"

        val cpuReq_Api: Cpu_Req
            get() = RetrofitClient.getClient(BASE_URL)!!.create(Cpu_Req::class.java)
    }
}