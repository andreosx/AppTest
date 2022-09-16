package com.br.apptest.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.R
import com.br.apptest.databinding.ListItemBinding
import com.br.apptest.domain.model.Item
import com.br.apptest.presenter.adapter.util.CellClickListener

class ItemListAdapter(val ctx: Context, val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<ItemListAdapter.MainActivityAdapterHolder>() {

    private var item = emptyList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityAdapterHolder {
        return MainActivityAdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainActivityAdapterHolder, position: Int) {
        setValues(holder,item[position])
        setAcessibility(holder,item[position])
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

    private fun setValues(holder: MainActivityAdapterHolder, item: Item){
        holder.binding.repositoryName.text = item.name
        holder.binding.repositoryDescription.text = item.description
        holder.binding.repositoryForkCount.text = item.forks_count.toString()
        holder.binding.repositoryStarCount.text = item.stargazers_count.toString()
        holder.binding.ownerUsername.text =item.owner.login

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(item)
        }
    }

    private fun setAcessibility(holder: MainActivityAdapterHolder, item: Item){
        holder.binding.repositoryName.contentDescription = ctx.getString(R.string.repository_name,item.name)
        holder.binding.repositoryDescription.contentDescription = ctx.getString(R.string.repository_description,item.description)
        holder.binding.repositoryForkCount.contentDescription = ctx.getString(R.string.forks_description,item.forks_count.toString())
        holder.binding.repositoryStarCount.contentDescription = ctx.getString(R.string.star_description,item.stargazers_count.toString())
        holder.binding.ownerUsername.contentDescription = ctx.getString(R.string.owner_description,item.owner.login)
    }
}