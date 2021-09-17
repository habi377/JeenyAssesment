package com.habib.jeenyassesment.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.habib.jeenyassesment.data.local.models.MostViewedArticleDomainModel
import com.habib.jeenyassesment.databinding.MostViewedItemBinding
import com.habib.jeenyassesment.utils.ArticleClick

class MostViewedArticlesViewHolder(
    private val binding: MostViewedItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MostViewedArticleDomainModel, clickListener: ArticleClick) {
        binding.apply {
            article= item
            mostViewedCallback = clickListener
            binding.executePendingBindings()
        }
    }
}