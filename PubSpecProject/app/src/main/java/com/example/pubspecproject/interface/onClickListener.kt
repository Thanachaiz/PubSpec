package com.example.pubspecproject.`interface`

import com.example.pubspecproject.model.VgaModel

interface onClickListener {
    fun onClickIO(item: VgaModel, indexPosition: Int, status :String)
    fun onClickSortBy(result: String?, indexPosition: Int, status :String ,tag : String)
}