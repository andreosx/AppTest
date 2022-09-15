package com.br.apptest.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.databinding.ListItemBinding
import com.br.apptest.domain.model.Item
import com.picpay.desafio.android.presenter.adapter.common.ItemListDiffCallback
import com.picpay.desafio.android.presenter.adapter.common.ItemListItemViewHolder

class RepositoryListAdapter : RecyclerView.Adapter<ItemListItemViewHolder>() {

    var itens = emptyList<Item>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                ItemListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListItemViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListItemViewHolder, position: Int) {
        holder.bind(itens[position])
    }

    override fun getItemCount(): Int = itens.size
    
}