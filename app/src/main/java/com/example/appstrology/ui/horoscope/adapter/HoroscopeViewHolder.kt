package com.example.appstrology.ui.horoscope.adapter

import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.appstrology.databinding.HoroscopeItemBinding
import com.example.appstrology.domain.model.HoroscopeInfo

class HoroscopeViewHolder(private val binding: HoroscopeItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(horoscopeSign: HoroscopeInfo, clickListener: (HoroscopeInfo)-> Unit){
        binding.signImage.setImageResource(horoscopeSign.image)
        binding.signName.setText(horoscopeSign.name)
        binding.cardClickable.setOnClickListener{
//            clickListener(horoscopeSign)
            startAnimation(binding.cardClickable){
                clickListener(horoscopeSign)
            }
        }
    }

    private fun startAnimation( view: View,clickListener: ()-> Unit){
        view.animate().apply {
            duration = 333L
            interpolator = AccelerateInterpolator()
            rotationYBy(360f)
            withEndAction(clickListener)
            start()
        }
    }
}