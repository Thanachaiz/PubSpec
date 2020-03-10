package com.example.pubspecproject.ui.detailCpu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickCpuItem
import com.example.pubspecproject.adapter.CpuItemAdapter
import com.example.pubspecproject.model.CpuModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.DecimalFormat

class DetailCpuActivity : AppCompatActivity(), onClickCpuItem {

    private lateinit var bottomSheetView: View
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

    override fun CpuAddItemClick(resultCpu: CpuModel?,imageItem: String ,position: Int) {
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

    override fun CpuDetailItemClick(resultCpu: CpuModel?,imageItem: String, position: Int) {

        val bottomSheetDialog = BottomSheetDialog(this)
        val formatter = DecimalFormat("#,###,###")
        bottomSheetView = layoutInflater.inflate(R.layout.detail_bottomsheet, null)

        if (resultCpu != null){

            val imageView: ImageView = bottomSheetView.findViewById(R.id.image_vga)
            val convertFormat = formatter.format(resultCpu.cpu_price_adv)

            Glide.with(bottomSheetView)
                .load(imageItem)
                .into(imageView)

            bottomSheetView.findViewById<TextView>(R.id.text_brand_model).text = "${resultCpu.cpu_brand} ${resultCpu.cpu_model}"
            bottomSheetView.findViewById<TextView>(R.id.text_price_vga).text = convertFormat
            bottomSheetView.findViewById<TextView>(R.id.text_brand).text = resultCpu.cpu_brand
            bottomSheetView.findViewById<TextView>(R.id.text_model).text = resultCpu.cpu_model
        }
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
    }

    companion object {
        private val TAG = "RecyclerViewCPU"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }
}
