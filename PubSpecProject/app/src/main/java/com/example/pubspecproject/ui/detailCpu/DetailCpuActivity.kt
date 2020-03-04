package com.example.pubspecproject.ui.detailCpu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickCpuItem
import com.example.pubspecproject.adapter.CpuItemAdapter
import com.example.pubspecproject.model.CpuModel

class DetailCpuActivity : AppCompatActivity(), onClickCpuItem {

    lateinit var cpuModel : DetailCpu_ViewModel
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cpu)
        recyclerView = findViewById(R.id.recycler_view_cpu)

        cpuModel = ViewModelProviders.of(this).get(DetailCpu_ViewModel::class.java)
        cpuModel.getAllCpu()?.observe(this, Observer { cpuModel ->

            initDataSet(cpuModel)
        })
    }

    private fun initDataSet(result: ArrayList<CpuModel>?) {
        recyclerView.also {
            it.layoutManager = GridLayoutManager(this@DetailCpuActivity, SPAN_COUNT)
            it.setHasFixedSize(true)
            it.adapter = CpuItemAdapter(result, this)
        }
    }

    override fun CpuAddItemClick(resultCpu: CpuModel?, imageItem: String, position: Int) {
        val brandCpu = resultCpu?.cpu_brand
        val cpuModel = resultCpu?.cpu_model
        val priceCpu = resultCpu?.cpu_price_adv
        val backResult = Intent()

        backResult.putExtra("name_cpu", "$brandCpu $cpuModel")
        backResult.putExtra("image_cpu", imageItem)
        backResult.putExtra("price_cpu", priceCpu)

        setResult(Activity.RESULT_OK, backResult)
        finish()
    }

    override fun CpuDetailItemClick(resultCpu: CpuModel?, position: Int) {

    }

    companion object {
        private val TAG = "RecyclerViewCPU"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }
}
