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

class RepoAdapter(val ctx: Context, val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<RepoAdapter.MainActivityAdapterHolder>() {

    private var item = emptyList<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityAdapterHolder {
        return MainActivityAdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_repo, parent, false))
    }

    override fun onBindViewHolder(holder: MainActivityAdapterHolder, position: Int) {
        setValues(holder,item[position])
        setAcessibility(holder,item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    class MainActivityAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = AdapterRepoBinding.bind(itemView)
    }

    fun updateList(Repo: List<Repo>, oldCount: Int, tvShowListSize: Int) {
        this.item = Repo
        notifyDataSetChanged()
        notifyItemRangeInserted(oldCount, tvShowListSize)
    }

    private fun setValues(holder: MainActivityAdapterHolder, repo: Repo){
        holder.binding.repositoryName.text = repo.name
        holder.binding.repositoryDescription.text = repo.description
        holder.binding.repositoryForkCount.text = repo.forks_count.toString()
        holder.binding.repositoryStarCount.text = repo.stargazers_count.toString()
        holder.binding.ownerUsername.text = repo.owner.login

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(repo)
        }
    }

    private fun setAcessibility(holder: MainActivityAdapterHolder, repo: Repo){
        holder.binding.repositoryName.contentDescription = ctx.getString(R.string.repository_name,repo.name)
        holder.binding.repositoryDescription.contentDescription = ctx.getString(R.string.repository_description,repo.description)
        holder.binding.repositoryForkCount.contentDescription = ctx.getString(R.string.forks_description,repo.forks_count.toString())
        holder.binding.repositoryStarCount.contentDescription = ctx.getString(R.string.star_description,repo.stargazers_count.toString())
        holder.binding.ownerUsername.contentDescription = ctx.getString(R.string.owner_description,repo.owner.login)
    }
}