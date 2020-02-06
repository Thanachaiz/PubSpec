package com.example.pubspecproject

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("vgaImage")

fun loadImageVga(view: ImageView, url: String){
    val defaultUrlImage = "https://www.advice.co.th/pic-pc/vga/"
    Glide.with(view)
        .load(defaultUrlImage + url)
        .into(view)
}