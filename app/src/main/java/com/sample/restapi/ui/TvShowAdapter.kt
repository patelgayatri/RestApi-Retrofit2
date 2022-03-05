package com.sample.restapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sample.restapi.data.models.TvShowItem
import com.sample.restapi.databinding.ItemTvShowBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    private val diffCallBack = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var tvShows: List<TvShowItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTvShowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = tvShows[position]
        holder.binding.apply {
            textview.text = currentItem.name
            imageView.load(currentItem.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = tvShows.size


}