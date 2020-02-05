package com.example.pubspecproject.api

import androidx.lifecycle.MutableLiveData
import com.example.pubspecproject.model.VgaModel
import retrofit2.Call
import retrofit2.http.GET

interface Vga_Req {

    @GET("vga")
    fun groupListVga(): Call<ArrayList<VgaModel>>

    object getVga {

        val BASE_URL = "https://www.advice.co.th/pc/get_comp/"

        val vgaReq_Api: Vga_Req
            get() = RetrofitClient.getClient(BASE_URL)!!.create(Vga_Req::class.java)
    }
}