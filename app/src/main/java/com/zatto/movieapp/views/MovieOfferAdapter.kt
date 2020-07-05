package com.zatto.movieapp.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zatto.movieapp.data.model.MovieData
import com.zatto.movieapp.databinding.MovieItemsBinding

class MovieOfferAdapter : RecyclerView.Adapter<MovieOfferAdapter.ViewHolder>() {
    private var items: MutableList<MovieData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: MovieItemsBinding =
            MovieItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun update(data: List<MovieData>) {
        items.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: MovieItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieData) {
            binding.itemDetails = item
            binding.executePendingBindings()
        }

    }

}



