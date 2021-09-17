package com.habib.jeenyassesment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.habib.jeenyassesment.adapters.viewholders.MostViewedArticlesViewHolder
import com.habib.jeenyassesment.data.local.models.MostViewedArticleDomainModel
import com.habib.jeenyassesment.databinding.MostViewedItemBinding
import com.habib.jeenyassesment.utils.ArticleClick

class MostViewedArticlesAdapter (private val clickListener: ArticleClick) : RecyclerView.Adapter<MostViewedArticlesViewHolder>(){

    var articles : List<MostViewedArticleDomainModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostViewedArticlesViewHolder {
        return MostViewedArticlesViewHolder(
            MostViewedItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: MostViewedArticlesViewHolder, position: Int) {
        val item  = articles[position]
        holder.bind(item,clickListener)
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}