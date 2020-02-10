package com.example.pubspecproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.databinding.VgaItemBinding
import com.example.pubspecproject.model.VgaModel

class CustomAdapter (private val dataSet: ArrayList<VgaModel>? = null) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

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
        holder.recyclerVgaItemBinding.vgaItem = dataSet?.get(position)
        holder.bind(result)
    }

    class ViewHolder(val recyclerVgaItemBinding: VgaItemBinding) : RecyclerView.ViewHolder(recyclerVgaItemBinding.root) {
        private val viewRoot = recyclerVgaItemBinding.root

        init {
            // Define click listener for the ViewHolder's View.
            viewRoot.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
        }

        fun bind(result: VgaModel?){
            val defaultUrlImage = "https://www.advice.co.th/pic-pc/vga/"

            Glide.with(recyclerVgaItemBinding.imageVga)
                .load(defaultUrlImage + result?.vga_picture)
                .into(recyclerVgaItemBinding.imageVga)
        }
    }

    companion object {
        private val TAG = "CustomAdapter"
    }
}