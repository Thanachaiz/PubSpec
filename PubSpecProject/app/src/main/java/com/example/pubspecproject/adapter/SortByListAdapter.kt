package com.example.pubspecproject.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickListener

class SortByListAdapter (private val onClickSort: onClickListener, private val sortListItem: ArrayList<String>? = null) :
    RecyclerView.Adapter<SortByListAdapter.SortViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.sort_item, parent, false)

        return SortViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sortListItem?.size ?:0
    }

    override fun onBindViewHolder(holder: SortViewHolder, position: Int) {
        val result = sortListItem?.get(position)

        holder.bind(result, onClickSort)
    }

    class SortViewHolder(v : View): RecyclerView.ViewHolder(v) {
        private var textSort : TextView = v.findViewById(R.id.text_sort)

//        init {
//            v.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
//        }
        fun bind(result: String?, onClickListener: onClickListener){
            textSort.text = result

            itemView.setOnClickListener {
                onClickListener.onClickSortBy(result, adapterPosition, "onClickSort")
            }
        }
    }

    companion object {
        private val TAG = "SortAdapter"
    }

}