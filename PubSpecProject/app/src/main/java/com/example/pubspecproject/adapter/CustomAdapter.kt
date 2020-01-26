package com.example.pubspecproject.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.R
import com.example.pubspecproject.model.VgaModel

class CustomAdapter (private val dataSet: ArrayList<VgaModel>? = null) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.vga_item, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int{
        return dataSet?.size ?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")
        holder.bind(dataSet?.get(position))
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textViewName: TextView = v.findViewById(R.id.text_vga)
        val textViewBrand: TextView = v.findViewById(R.id.text_brand)
        val imageVga: ImageView = v.findViewById(R.id.image_vga)

        init {
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
        }

        fun bind(result: VgaModel?){
            val defaultUrlImage = "https://www.advice.co.th/pic-pc/vga/"

            textViewBrand.text = result?.vga_brand
            textViewName.text = result?.vga_model

            Glide.with(itemView)
                .load(defaultUrlImage+result?.vga_picture)
                .into(imageVga)
        }
    }

    companion object {
        private val TAG = "CustomAdapter"
    }
}