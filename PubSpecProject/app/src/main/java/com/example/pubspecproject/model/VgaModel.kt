package com.example.pubspecproject.model

import android.os.Parcel
import android.os.Parcelable

data class VgaModel(
    val adv_id: String?,
//    val adv_path: String?,
//    val adv_soldout: Int?,
//    val banana_id: Int?,
    val cat: String?,
//    val commore_id: String?,
//    val currentweek: Int?,
    val id: Int?,
//    val is_highlight: Int?,
//    val jedi_id: String?,
//    val jib_id: Int?,
//    val last2week: Int?,
//    val lastupdate: Int?,
//    val lastweek: Int?,
//    val lowest_price: Int?,
    val price_adv: Int?,
//    val score3D11: Int?,
//    val soldout: Int?,
//    val timestamp_tmp_close: String?,
//    val tk_id: String?,
//    val tmp_close: Int?,
//    val topvalue_id: Int?,
//    val vga_3d: String?,
//    val vga_bit: String?,
    val vga_brand: String?,
    val vga_bus_type: String?,
//    val vga_cat_seo: String?,
    val vga_cf_sli: String?,
    val vga_chipset: String?,
    val vga_clock: String?,
//    val vga_code_name: String?,
//    val vga_cooling: String?,
//    val vga_directx: Int?,
    val vga_displayport: Int?,
    val vga_dsub: Int?,
    val vga_dvi: Int?,
//    val vga_feature: String?,
    val vga_hdmi: Int?,
    val vga_id: Int?,
//    val vga_max_reso: String?,
    val vga_mdisplayport: Int?,
    val vga_mem_model: String?,
    val vga_mem_size: String?,
    val vga_mem_speed: String?,
    val vga_mem_type: String?,
    val vga_mhdmi: Int?,
    val vga_model: String?,
//    val vga_option_port: String?,
    val vga_picture: String?,
    val vga_power: String?,
    val vga_price_adv: Int?,
    val vga_price_ban: Int?,
//    val vga_price_busitek: Int?,
//    val vga_price_commore: Int?,
//    val vga_price_etc: Int?,
//    val vga_price_hwh: Int?,
//    val vga_price_jedi: Int?,
    val vga_price_jib: Int?,
//    val vga_price_tk: Int?,
//    val vga_price_topvalue: Int?,
    val vga_psu_require: String?,
//    val vga_score: Int?,
    val vga_series: String?
//    val vga_shader: Double?,
//    val vga_shader_unit: Int?,
//    val vga_tech: String?,
//    val vga_waranty: Int?,
//    val view: Int?
//    val `when`: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    )
    {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(adv_id)
        parcel.writeString(cat)
        parcel.writeValue(id)
        parcel.writeValue(price_adv)
        parcel.writeString(vga_brand)
        parcel.writeString(vga_bus_type)
        parcel.writeString(vga_cf_sli)
        parcel.writeString(vga_chipset)
        parcel.writeString(vga_clock)
        parcel.writeValue(vga_displayport)
        parcel.writeValue(vga_dsub)
        parcel.writeValue(vga_dvi)
        parcel.writeValue(vga_hdmi)
        parcel.writeValue(vga_id)
        parcel.writeValue(vga_mdisplayport)
        parcel.writeString(vga_mem_model)
        parcel.writeString(vga_mem_size)
        parcel.writeString(vga_mem_speed)
        parcel.writeString(vga_mem_type)
        parcel.writeValue(vga_mhdmi)
        parcel.writeString(vga_model)
        parcel.writeString(vga_picture)
        parcel.writeString(vga_power)
        parcel.writeValue(vga_price_adv)
        parcel.writeValue(vga_price_ban)
        parcel.writeValue(vga_price_jib)
        parcel.writeString(vga_psu_require)
        parcel.writeString(vga_series)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VgaModel> {
        override fun createFromParcel(parcel: Parcel): VgaModel {
            return VgaModel(parcel)
        }

        override fun newArray(size: Int): Array<VgaModel?> {
            return arrayOfNulls(size)
        }
    }
}