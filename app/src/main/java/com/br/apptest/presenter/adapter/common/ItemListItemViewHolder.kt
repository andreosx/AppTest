package com.picpay.desafio.android.presenter.adapter.common

import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.databinding.ListItemBinding
import com.br.apptest.domain.model.Item

classListItemViewHolder(
    val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.repositoryName.text = item?.name
        binding.repositoryDescription.text = item?.description
        binding.repositoryForkCount.text = item?.forks_count.toString()
        binding.repositoryStarCount.text = item?.stargazers_count.toString()
        binding.ownerUsername.text = item?.created_at
    }
}