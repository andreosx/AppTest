package com.br.apptest.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.R
import com.br.apptest.databinding.AdapterRepoBinding
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.presenter.adapter.util.CellClickListener
import com.bumptech.glide.Glide

class RepoAdapter(val ctx: Context, private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    private var item = emptyList<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(ctx).inflate(R.layout.adapter_repo, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount() = item.size

    fun updateList(Repo: List<Repo>, oldCount: Int, tvShowListSize: Int) {
        this.item = Repo
        notifyDataSetChanged()
        notifyItemRangeInserted(oldCount, tvShowListSize)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = AdapterRepoBinding.bind(view)

        fun bind(repo: Repo) {
            with(binding) {
                binding.repositoryName.text = repo.name
                binding.repositoryDescription.text = repo.description
                binding.repositoryForkCount.text = repo.forks_count.toString()
                binding.repositoryStarCount.text = repo.stargazers_count.toString()
                binding.ownerUsername.text = repo.owner.login
            }
        }
    }

}