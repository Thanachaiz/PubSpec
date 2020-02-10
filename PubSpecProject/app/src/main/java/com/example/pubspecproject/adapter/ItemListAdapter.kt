package com.example.pubspecproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickBuildListener
import com.example.pubspecproject.databinding.ListitemViewBinding
import com.example.pubspecproject.model.ItemListModel

class ItemListAdapter(val onClickBuild: onClickBuildListener) : ListAdapter<ItemListModel, ItemListAdapter.ItemListViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder =
        ItemListViewHolder(
            DataBindingUtil.inflate<ListitemViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.listitem_view,
            parent,
            false
        ))

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        val result = getItem(position)
        holder.bind(result, onClickBuild)
    }

    class ItemListViewHolder(viewBindingBuildItem: ListitemViewBinding) : RecyclerView.ViewHolder(viewBindingBuildItem.root) {

        fun bind(
            result: ItemListModel,
            onClickBuild: onClickBuildListener
        ) = with(itemView){


        }
    }

    companion object {
        private val TAG = "ItemListAdapter"
    }
}

class DiffCallback : DiffUtil.ItemCallback<ItemListModel>(){
    override fun areItemsTheSame(oldItem: ItemListModel, newItem: ItemListModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ItemListModel, newItem: ItemListModel): Boolean {
        return oldItem == newItem
    }

}
