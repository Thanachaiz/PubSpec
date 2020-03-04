package com.example.pubspecproject.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickCpuItem
import com.example.pubspecproject.`interface`.onClickVgaItem
import com.example.pubspecproject.databinding.CpuItemBinding
import com.example.pubspecproject.databinding.VgaItemBinding
import com.example.pubspecproject.model.CpuModel
import com.example.pubspecproject.model.VgaModel

class CpuItemAdapter (
    private val dataSet: ArrayList<CpuModel>? = null,
    val onClickCpuItem: onClickCpuItem
) : RecyclerView.Adapter<CpuItemAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate<CpuItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.cpu_item,
                parent,
                false
            )
        )

    override fun getItemCount() = dataSet!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = dataSet?.get(position)
        holder.viewCpuItemBinding.cpuItem = dataSet?.get(position)
        holder.bind(result, onClickCpuItem)
    }

    class ViewHolder(val viewCpuItemBinding: CpuItemBinding) : RecyclerView.ViewHolder(viewCpuItemBinding.root) {
        private val viewRoot = viewCpuItemBinding.root

        init {
            // Define click listener for the ViewHolder's View.
            viewRoot.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
        }

        fun bind(result: CpuModel?, onClickCpuItem: onClickCpuItem){
            val defaultUrlImage = "https://www.advice.co.th/pic-pc/cpu/"
            val imageItem = defaultUrlImage + result?.cpu_picture

            Glide.with(viewCpuItemBinding.imageVga)
                .load(imageItem)
                .into(viewCpuItemBinding.imageVga)

            viewCpuItemBinding.btnAdd.setOnClickListener {
                onClickCpuItem.CpuAddItemClick(result, imageItem, adapterPosition)
            }
        }
    }

    companion object {
        private val TAG = "VgaItemAdapter"
    }
}