package com.example.pubspecproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.model.VgaModel

class CustomAdapter (private val dataSet: ArrayList<VgaModel>? = null) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.vga_item, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount() = dataSet!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")


        holder.bind(dataSet?.get(position))
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView
        val imageVga: ImageView = v.findViewById(R.id.image_vga)

        init {
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
            textView = v.findViewById(R.id.text_vga)
        }

        fun bind(result: VgaModel?){
            val defaultUrlImage = "https://www.advice.co.th/pic-pc/vga/"

            textView.text = result?.vga_model

            Glide.with(itemView)
                .load(defaultUrlImage+result?.vga_picture)
                .into(imageVga)
        }
    }

    companion object {
        private val TAG = "CustomAdapter"
    }
}