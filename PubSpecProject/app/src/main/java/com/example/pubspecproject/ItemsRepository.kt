package com.example.pubspecproject

import android.util.Log
import com.example.pubspecproject.api.Vga_Req
import com.example.pubspecproject.model.VgaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsRepository {

    private var nextItem = 1

    fun getItemPage(pageSize: Int = 20): List<String>{

        val items = mutableListOf<String>()
        val lastItem = nextItem + pageSize -1

        for (i in nextItem..lastItem){
            items.add("Item $i")
        }
        nextItem = lastItem +1

        return  items
    }
    fun callGetApiVga() : MutableList<ArrayList<VgaModel>>? {

        val itemResult : MutableList<ArrayList<VgaModel>>? = mutableListOf<ArrayList<VgaModel>>()

        Vga_Req.getVga.vgaReq_Api.groupListVga().enqueue(object : Callback<ArrayList<VgaModel>> {

            override fun onResponse(call: Call<ArrayList<VgaModel>>, response: Response<ArrayList<VgaModel>>) {
                Log.d("DataSet",response.body().toString())
                if (response.isSuccessful){
//                    val data : ArrayList<VgaModel> = (response.body() as ArrayList<VgaModel>)
//                    _listResult.value = data

                    response.body()?.also {

                        itemResult?.add(it)
                    }
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

        return itemResult
    }
}