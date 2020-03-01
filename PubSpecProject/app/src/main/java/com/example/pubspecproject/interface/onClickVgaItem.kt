package com.example.pubspecproject.`interface`

import com.example.pubspecproject.model.VgaModel

interface onClickVgaItem{
    fun VgaAddItemClick(resultVga : VgaModel?, imageItem : String, position: Int)
    fun VgaDetailItemClick(resultVga : VgaModel?, position: Int)
}