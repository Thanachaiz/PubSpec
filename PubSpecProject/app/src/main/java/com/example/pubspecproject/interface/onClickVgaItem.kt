package com.example.pubspecproject.`interface`

import com.example.pubspecproject.model.CpuModel
import com.example.pubspecproject.model.VgaModel

interface onClickVgaItem{
    fun VgaAddItemClick(resultVga : VgaModel?, imageItem : String, position: Int)
    fun VgaDetailItemClick(resultVga : VgaModel?,imageItem : String, position: Int)
}
interface onClickCpuItem{
    fun CpuAddItemClick(resultCpu : CpuModel?, imageItem : String, position: Int)
    fun CpuDetailItemClick(resultCpu : CpuModel?,imageItem : String, position: Int)
}