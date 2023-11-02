package com.example.appstrology.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstrology.databinding.HoroscopeItemBinding
import com.example.appstrology.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList : List<HoroscopeInfo> = emptyList(),
                       private val clickListener : (HoroscopeInfo) -> Unit
): RecyclerView.Adapter<HoroscopeViewHolder>()  {

    fun updateList(list:List<HoroscopeInfo>){
        horoscopeList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val binding =HoroscopeItemBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
        return HoroscopeViewHolder(binding)

    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscopeItem = horoscopeList[position]
        holder.bind(horoscopeItem,clickListener)

    }

    override fun getItemCount(): Int = horoscopeList.size




}