package com.example.pubspecproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.R
import com.example.pubspecproject.`interface`.onClickBuildItem

class ItemListAdapter(
    val clickBuildItem: onClickBuildItem
){

}
//    :
//    ListAdapter<ItemListModel, ItemListAdapter.ItemListViewHolder>(DiffCallback()){
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder =
//        ItemListViewHolder(
//            DataBindingUtil.inflate<ListitemViewBinding>(
//            LayoutInflater.from(parent.context),
//            R.layout.listitem_view,
//            parent,
//            false
//        ))
//
//    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
//        holder.viewBindingBuildItem.buildItem = getItem(position)
//        holder.bind(getItem(position), clickBuildItem)
//    }
//
//    class ItemListViewHolder(val viewBindingBuildItem: ListitemViewBinding) : RecyclerView.ViewHolder(viewBindingBuildItem.root) {
//
//        fun bind(
//            result: ItemListModel,
//            clickBuildItem: onClickBuildItem
//        )= with(itemView){
//
//            itemView.setOnClickListener {
//                clickBuildItem.clickBuildListener()
//            }
//        }
//    }
//
//    companion object {
//        private val TAG = "ItemListAdapter"
//    }
//}
//
//class DiffCallback : DiffUtil.ItemCallback<ItemListModel>(){
//    override fun areItemsTheSame(oldItem: ItemListModel, newItem: ItemListModel): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(oldItem: ItemListModel, newItem: ItemListModel): Boolean {
//        return oldItem == newItem
//    }
//
//}
