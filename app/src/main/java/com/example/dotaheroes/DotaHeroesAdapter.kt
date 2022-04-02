package com.example.dotaheroes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dotaheroes.databinding.DotaHeroesRvItemBinding


class DotaHeroesAdapter(val dotaArray: List<DotaHeroes>, val context: Context):
RecyclerView.Adapter<DotaHeroesAdapter.MyViewHolder>(){
    inner class MyViewHolder(var binding: DotaHeroesRvItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: DotaHeroesRvItemBinding = DotaHeroesRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context)
            .load("https://api.opendota.com" + dotaArray[position].img)
            .into(holder.binding.heroIcon)
        holder.binding.heroName.text = dotaArray[position].localized_name
        when(dotaArray[position].primary_attr) {
            "agi" -> Glide.with(context)
                .load("https://static.wikia.nocookie.net/dota2_gamepedia/images/2/2d/Agility_attribute_symbol.png/revision/latest/scale-to-width-down/45?cb=20180323111717")
                .into(holder.binding.heroAttribute)
            "str" -> Glide.with(context)
                .load("https://static.wikia.nocookie.net/dota2_gamepedia/images/7/7a/Strength_attribute_symbol.png/revision/latest/scale-to-width-down/45?cb=20180323111829")
                .into(holder.binding.heroAttribute)
            else -> Glide.with(context)
                .load("https://static.wikia.nocookie.net/dota2_gamepedia/images/5/56/Intelligence_attribute_symbol.png/revision/latest/scale-to-width-down/45?cb=20180323111753")
                .into(holder.binding.heroAttribute)
        }
    }

    override fun getItemCount(): Int {
        return dotaArray.size
    }


}