package com.viewpager2slider.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viewpager2slider.databinding.ImageItemBinding
import com.viewpager2slider.model.SplashModel

class SplashAdapter(private var data: ArrayList<SplashModel>) :
    RecyclerView.Adapter<SplashAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ImageViewHolder(private val imageItemBinding: ImageItemBinding) :
        RecyclerView.ViewHolder(imageItemBinding.root){

            fun bind(model: SplashModel){
                imageItemBinding.apply {
                    clMain.setBackgroundColor(model.colorCode)
                    tvTitle.text = model.introTitle
                    tvSubTitle.text = model.introSubTitle
                }
            }
        }
}