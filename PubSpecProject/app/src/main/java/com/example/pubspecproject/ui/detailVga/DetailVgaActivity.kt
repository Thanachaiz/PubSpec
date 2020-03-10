package com.example.pubspecproject.ui.detailVga

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.adapter.VgaItemAdapter
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickVgaItem
import com.example.pubspecproject.model.VgaModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.detail_bottomsheet.*
import java.text.DecimalFormat

@SuppressLint("ParcelCreator")
class DetailVgaActivity : AppCompatActivity(), onClickVgaItem {

    private lateinit var bottomSheetView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var vgaModel : DetailVga_ViewModel

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

    override fun VgaDetailItemClick(resultVga: VgaModel?,imageItem: String, position: Int) {

        val bottomSheetDialog = BottomSheetDialog(this)
        val formatter = DecimalFormat("#,###,###")
        bottomSheetView = layoutInflater.inflate(R.layout.detail_bottomsheet, null)

        if (resultVga != null){

            val imageView: ImageView = bottomSheetView.findViewById(R.id.image_vga)
            val convertFormat = formatter.format(resultVga.vga_price_adv)

            Glide.with(bottomSheetView)
                .load(imageItem)
                .into(imageView)

            bottomSheetView.findViewById<TextView>(R.id.text_brand_model).text = "${resultVga.vga_brand} ${resultVga.vga_model}"
            bottomSheetView.findViewById<TextView>(R.id.text_price_vga).text = convertFormat
            bottomSheetView.findViewById<TextView>(R.id.text_brand).text = resultVga.vga_brand
            bottomSheetView.findViewById<TextView>(R.id.text_model).text = resultVga.vga_model
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
        private val TAG = "RecyclerViewFragment"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }
}
