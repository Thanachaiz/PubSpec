package com.example.pubspecproject.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.R
import com.example.pubspecproject.databinding.VgaItemBinding
import com.example.pubspecproject.model.VgaModel

class VgaItemAdapter (private val dataSet: ArrayList<VgaModel>? = null) :
    RecyclerView.Adapter<VgaItemAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate<VgaItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.vga_item,
                parent,
                false
            )
        )

    override fun getItemCount() = dataSet!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = dataSet?.get(position)
        holder.viewVgaItemBinding.vgaItem = dataSet?.get(position)
        holder.bind(result)
    }

    class ViewHolder(val viewVgaItemBinding: VgaItemBinding) : RecyclerView.ViewHolder(viewVgaItemBinding.root) {
        private val viewRoot = viewVgaItemBinding.root

        init {
            // Define click listener for the ViewHolder's View.
            viewRoot.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
        }

        fun bind(result: VgaModel?){
            val defaultUrlImage = "https://www.advice.co.th/pic-pc/vga/"

            Glide.with(viewVgaItemBinding.imageVga)
                .load(defaultUrlImage + result?.vga_picture)
                .into(viewVgaItemBinding.imageVga)
        }
    }

    companion object {
        private val TAG = "VgaItemAdapter"
    }
}