package com.example.pubspecproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.`interface`.onClickListener
import com.example.pubspecproject.adapter.CustomAdapter
import com.example.pubspecproject.adapter.SortByListAdapter
import com.example.pubspecproject.api.Vga_Req.getVga.vgaReq_Api
import com.example.pubspecproject.model.VgaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("ParcelCreator")
class DetailVgaActivity : AppCompatActivity(), onClickListener {
    override fun onClickIO(item: VgaModel, indexPosition: Int, status: String) {

    }

    override fun onClickSortBy(result: String?, indexPosition: Int, status: String, tag: String) {
        when(status){
            "ClickSort" ->{
                Log.d(TAG, "Element $indexPosition clicked.")
                initDataSet(listResult, result)
            }
        }
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerSort: RecyclerView
    var listResult : ArrayList<VgaModel>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vga)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerSort = findViewById(R.id.recyclerSort)

        initSortDataSet()
        callGetApiVga()
//        if (savedInstanceState == null || !savedInstanceState.containsKey("key")){
//            callGetApiVga()
////            supportFragmentManager.beginTransaction()
////                .replace(R.id.container, DetailVgaFragment.newInstance())
////                .commitNow()
//        }else{
//            listResult = savedInstanceState.getParcelableArrayList("key")
//            initDataSet(listResult, null)
//        }
    }

    private fun callGetApiVga() {

        vgaReq_Api.groupListVga().enqueue(object : Callback<ArrayList<VgaModel>>{

            override fun onResponse(call: Call<ArrayList<VgaModel>>, response: Response<ArrayList<VgaModel>>) {
                Log.d("DataSet",response.body().toString())
                if (response.isSuccessful){
                    listResult = response.body()

                    val filterList = listResult!!.filter { vgaModel: VgaModel -> vgaModel.price_adv != 0 } as ArrayList

//                    print(result)
                    initDataSet(filterList, null)
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

//    override fun onSaveInstanceState(outState: Bundle) {
//
//        outState.putParcelableArrayList("key", listResult)
//        super.onSaveInstanceState(outState)
//    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private fun initDataSet(result: ArrayList<VgaModel>?, sortBy : String?) {

        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@DetailVgaActivity, SPAN_COUNT)
            recyclerView.adapter = CustomAdapter(result)
        }
        recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun initSortDataSet() {

        val listDataSort = arrayListOf("ราคา:ต่ำสุด -> สูงสุด","ราคา:สูงสุด -> ต่ำสุด")
        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerSort.apply {
            layoutManager = GridLayoutManager(this@DetailVgaActivity, SPAN_COUNT)
            recyclerSort.adapter = SortByListAdapter(this@DetailVgaActivity, listDataSort)
        }
    }

    companion object {
        private val TAG = "RecyclerViewFragment"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }
}
