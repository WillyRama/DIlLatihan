package com.willyramad.dillatihan.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.willyramad.dillatihan.databinding.ItemProfukBinding
import com.willyramad.dillatihan.modul.ProfukResponItem

class AdapterProduk (var listProduk: List<ProfukResponItem>): RecyclerView.Adapter<AdapterProduk.ViewHodler>() {
    class ViewHodler(var binding : ItemProfukBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        var view = ItemProfukBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHodler(view)
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        holder.binding.namePro.text = listProduk[position].name
        holder.binding.categoryPro.text = listProduk[position].brand
        holder.binding.pricePro.text = listProduk[position].price


        Glide.with(holder.itemView.context).load(listProduk[position].imageLink).into(holder.binding.imgPro)
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }
}