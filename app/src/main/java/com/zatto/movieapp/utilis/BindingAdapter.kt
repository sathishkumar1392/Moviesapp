package com.zatto.movieapp.utilis

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.zatto.movieapp.R
import com.zatto.movieapp.data.endpointpath.Constant


@BindingAdapter("image")
fun setImageUrl(view:ImageView,imageUrl:String){
    imageUrl.let {
     Glide.with(view).load(Constant.TAG_IMAGEURL + imageUrl).
     placeholder(R.drawable.preview).into(view)
    }
}


@SuppressLint("SetTextI18n")
@BindingAdapter("available")
fun setIsAvailable(view:TextView,isAvailable : Boolean){
    if(isAvailable){
        view.text = "Available"
    }else{
        view.text = "Not in Stock"

    }
}