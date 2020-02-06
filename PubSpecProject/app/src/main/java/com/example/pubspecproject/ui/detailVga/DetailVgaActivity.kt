package com.example.pubspecproject.ui.detailVga

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.CustomAdapter
import com.example.pubspecproject.R
import com.example.pubspecproject.model.VgaModel

@SuppressLint("ParcelCreator")
class DetailVgaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var vgaModel : DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vga)
        recyclerView = findViewById(R.id.recyclerView)

        vgaModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        vgaModel.getAllVga()?.observe(this, Observer { vgaModel ->
            initDataSet(vgaModel)
        })
    }

    private fun initDataSet(result: ArrayList<VgaModel>?) {
        // Set CustomAdapter as the adapter for RecyclerView.
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@DetailVgaActivity,
                SPAN_COUNT
            )
            recyclerView.adapter = CustomAdapter(result)
        }
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
