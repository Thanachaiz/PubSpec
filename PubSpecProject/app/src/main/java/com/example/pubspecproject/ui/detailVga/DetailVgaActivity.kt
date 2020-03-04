package com.example.pubspecproject.ui.detailVga

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.adapter.VgaItemAdapter
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickVgaItem
import com.example.pubspecproject.model.VgaModel

@SuppressLint("ParcelCreator")
class DetailVgaActivity : AppCompatActivity(), onClickVgaItem {

    private lateinit var recyclerView: RecyclerView
    lateinit var vgaModel : DetailVga_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vga)
        recyclerView = findViewById(R.id.recycler_view_vga)

        vgaModel = ViewModelProviders.of(this).get(DetailVga_ViewModel::class.java)
        vgaModel.getAllVga()?.observe(this, Observer { vgaModel ->
            initDataSet(vgaModel)
        })
    }

    private fun initDataSet(result: ArrayList<VgaModel>?) {
        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.also {
            it.layoutManager = GridLayoutManager(this@DetailVgaActivity, SPAN_COUNT)
            it.setHasFixedSize(true)
            it.adapter = VgaItemAdapter(result, this)
        }
    }

    override fun VgaAddItemClick(resultVga: VgaModel?,imageItem : String, position: Int) {

        val brandVga = resultVga?.vga_brand
        val memVga = resultVga?.vga_mem_model
        val nameVga = resultVga?.vga_code_name
        val priceVga = resultVga?.vga_price_adv
        val backResult = Intent()

        backResult.putExtra("name_vga", "$brandVga $nameVga $memVga")
        backResult.putExtra("image_vga", imageItem)
        backResult.putExtra("price_vga", priceVga)

        setResult(Activity.RESULT_OK, backResult)
        finish()
    }

    override fun VgaDetailItemClick(resultVga: VgaModel?, position: Int) {

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
    }

    companion object {
        private val TAG = "RecyclerViewFragment"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }
}
