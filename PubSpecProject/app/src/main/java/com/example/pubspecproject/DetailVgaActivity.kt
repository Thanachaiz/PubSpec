package com.example.pubspecproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.api.Vga_Req.getVga.vgaReq_Api
import com.example.pubspecproject.model.VgaModel
import com.example.pubspecproject.ui.detail_vga.DetailVgaFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("ParcelCreator")
class DetailVgaActivity() : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    var listResult : ArrayList<VgaModel>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vga)

        recyclerView = findViewById(R.id.recyclerView)

        if (savedInstanceState == null || !savedInstanceState.containsKey("key")){
            callGetApiVga()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailVgaFragment.newInstance())
                .commitNow()
        }else{
            listResult = savedInstanceState.getParcelableArrayList("key")
            initDataSet(listResult)
        }
    }

    private fun callGetApiVga() {

        vgaReq_Api.groupListVga().enqueue(object : Callback<ArrayList<VgaModel>>{

            override fun onResponse(call: Call<ArrayList<VgaModel>>, response: Response<ArrayList<VgaModel>>) {
                Log.d("DataSet",response.body().toString())
                if (response.isSuccessful){
                    listResult = response.body()
//                    print(result)
                    initDataSet(listResult)
                }
                else{
                    Log.e("ErrorBodyVgaCall", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<VgaModel>>, t: Throwable) {
                Log.e("DataSet","${t.message}")
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putParcelableArrayList("key", listResult)
        super.onSaveInstanceState(outState)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private fun initDataSet(result: ArrayList<VgaModel>?) {

        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@DetailVgaActivity, SPAN_COUNT)
            recyclerView.adapter = CustomAdapter(result)
        }
    }

    companion object {
        private val TAG = "RecyclerViewFragment"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }
}
