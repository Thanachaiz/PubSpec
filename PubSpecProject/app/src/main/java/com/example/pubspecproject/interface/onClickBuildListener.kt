package com.example.pubspecproject.`interface`

import com.example.pubspecproject.model.ItemListModel

interface onClickBuildListener {

    fun onClickBuildItem(itemListModel: ItemListModel, position: Int, status: String)
}