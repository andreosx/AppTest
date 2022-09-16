package com.br.apptest.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.R
import com.br.apptest.databinding.ListItemBinding
import com.br.apptest.domain.model.Item

class ItemListAdapter() :
    RecyclerView.Adapter<ItemListAdapter.MainActivityAdapterHolder>() {

    private var item = emptyList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityAdapterHolder {
        return MainActivityAdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainActivityAdapterHolder, position: Int) {
        holder.binding.repositoryName.text = item[position].name
        holder.binding.repositoryDescription.text = item[position].description
        holder.binding.repositoryForkCount.text = item[position].forks_count.toString()
        holder.binding.repositoryStarCount.text = item[position].stargazers_count.toString()
        holder.binding.ownerUsername.text = item[position].owner.login
    }

    override fun getItemCount(): Int {
        return item.size
    }

    class MainActivityAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    fun updateList(item: List<Item>, oldCount: Int, tvShowListSize: Int) {
        this.item = item
        notifyDataSetChanged()
        notifyItemRangeInserted(oldCount, tvShowListSize)
    }
}