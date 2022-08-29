package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.HorLayoutBinding
import com.example.newsapp.model.NewsImage

class TabLayoutAdapter :
    ListAdapter<NewsImage, TabLayoutAdapter.TablayoutViewHolder>(DiffCallBack()) {
    lateinit var onClick: (NewsImage) -> Unit
    private class DiffCallBack : DiffUtil.ItemCallback<NewsImage>() {
        override fun areItemsTheSame(oldItem: NewsImage, newItem: NewsImage): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsImage, newItem: NewsImage): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TablayoutViewHolder {
        return TablayoutViewHolder(
            HorLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TablayoutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TablayoutViewHolder(private val binding: HorLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(newItem: NewsImage) {
            binding.apply {
                textTitle.text = newItem.title
                textDesc.text = newItem.desc
                imageView.setImageResource(newItem.backImage)
            }
            itemView.setOnClickListener {
                onClick(newItem)
            }
        }
    }
}