package com.example.pubspecproject.model

data class ItemBuildModel (
    var listCpuBuild: CpuBuild,
    var listVgaBuild: VgaBuild
)

data class VgaBuild (
    var name_vga: String?,
    var image_vga: String?,
    var price_vga: Int?
)

data class CpuBuild (
    var name_cpu: String?,
    var image_cpu: String?,
    var price_cpu: Int?
)
