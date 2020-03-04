package com.example.pubspecproject.model

import android.os.Parcel
import android.os.Parcelable

data class CpuModel(
    val adv_id: String?,
//    val adv_path: String?,
//    val adv_soldout: Int,
//    val banana_id: Int,
//    val cat: String?,
//    val commore_id: String?,
//    val cpu_L2: String?,
//    val cpu_L3: String?,
//    val cpu_architec: String?,
    val cpu_brand: String?,
//    val cpu_bus: String?,
//    val cpu_ct: String?,
//    val cpu_frequency: String?,
//    val cpu_id: Int,
    val cpu_model: String?,
    val cpu_picture: String?,
//    val cpu_power: String?,
    val cpu_price_adv: Int
//    val cpu_price_ban: Int,
//    val cpu_price_busitek: Int,
//    val cpu_price_commore: Int,
//    val cpu_price_etc: Int,
//    val cpu_price_hwh: Int,
//    val cpu_price_jedi: Int,
//    val cpu_price_jib: Int,
//    val cpu_price_tk: Int,
//    val cpu_price_topvalue: String?,
//    val cpu_score: Int,
//    val cpu_series: String?,
//    val cpu_socket: String?,
//    val cpu_turbo: String?,
//    val cpu_vga_chip: Int,
//    val cpu_waranty: Int,
//    val currentweek: Int,
//    val id: Int,
//    val is_highlight: Int,
//    val jedi_id: String?,
//    val jib_id: Int,
//    val last2week: Int,
//    val lastupdate: Int,
//    val lastweek: Int,
//    val lowest_price: Int,
//    val price_adv: Int
//    val price_mark: Int,
//    val score3D11: Int,
//    val soldout: Int,
//    val timestamp_tmp_close: String?,
//    val tk_id: String?,
//    val tmp_close: Int,
//    val topvalue_id: String?,
//    val view: Int
//    val `when`: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
//        parcel.readInt(),
//        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
        parcel.readInt()
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(adv_id)
//        parcel.writeString(adv_path)
//        parcel.writeInt(adv_soldout)
//        parcel.writeInt(banana_id)
//        parcel.writeString(cat)
//        parcel.writeString(commore_id)
//        parcel.writeString(cpu_L2)
//        parcel.writeString(cpu_L3)
//        parcel.writeString(cpu_architec)
        parcel.writeString(cpu_brand)
//        parcel.writeString(cpu_bus)
//        parcel.writeString(cpu_ct)
//        parcel.writeString(cpu_frequency)
//        parcel.writeInt(cpu_id)
        parcel.writeString(cpu_model)
        parcel.writeString(cpu_picture)
//        parcel.writeString(cpu_power)
        parcel.writeInt(cpu_price_adv)
//        parcel.writeInt(cpu_price_ban)
//        parcel.writeInt(cpu_price_busitek)
//        parcel.writeInt(cpu_price_commore)
//        parcel.writeInt(cpu_price_etc)
//        parcel.writeInt(cpu_price_hwh)
//        parcel.writeInt(cpu_price_jedi)
//        parcel.writeInt(cpu_price_jib)
//        parcel.writeInt(cpu_price_tk)
//        parcel.writeString(cpu_price_topvalue)
//        parcel.writeInt(cpu_score)
//        parcel.writeString(cpu_series)
//        parcel.writeString(cpu_socket)
//        parcel.writeString(cpu_turbo)
//        parcel.writeInt(cpu_vga_chip)
//        parcel.writeInt(cpu_waranty)
//        parcel.writeInt(currentweek)
//        parcel.writeInt(id)
//        parcel.writeInt(is_highlight)
//        parcel.writeString(jedi_id)
//        parcel.writeInt(jib_id)
//        parcel.writeInt(last2week)
//        parcel.writeInt(lastupdate)
//        parcel.writeInt(lastweek)
//        parcel.writeInt(lowest_price)
//        parcel.writeInt(price_adv)
//        parcel.writeInt(price_mark)
//        parcel.writeInt(score3D11)
//        parcel.writeInt(soldout)
//        parcel.writeString(timestamp_tmp_close)
//        parcel.writeString(tk_id)
//        parcel.writeInt(tmp_close)
//        parcel.writeString(topvalue_id)
//        parcel.writeInt(view)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CpuModel> {
        override fun createFromParcel(parcel: Parcel): CpuModel {
            return CpuModel(parcel)
        }

        override fun newArray(size: Int): Array<CpuModel?> {
            return arrayOfNulls(size)
        }
    }

}