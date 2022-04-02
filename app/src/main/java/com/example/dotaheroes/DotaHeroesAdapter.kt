package com.example.dotaheroes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dotaheroes.databinding.DotaHeroesRvItemBinding


class DotaHeroesAdapter(val dotaArray: List<DotaHeroes>):
RecyclerView.Adapter<DotaHeroesAdapter.MyViewHolder>(){
    inner class MyViewHolder(var binding: DotaHeroesRvItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: DotaHeroesRvItemBinding = DotaHeroesRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with().load(dotaArray[position].img).into(holder.binding.heroIcon)
        holder.binding.heroName.text = dotaArray[position].localized_name
    }

    override fun getItemCount(): Int {
        return dotaArray.size
    }


}