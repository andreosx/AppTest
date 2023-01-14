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

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityAdapterHolder {
//        return MainActivityAdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_repo, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: MainActivityAdapterHolder, position: Int) {
//        setValues(holder,item[position])
//        setAcessibility(holder,item[position])
//    }
//
//    override fun getItemCount(): Int {
//        return item.size
//    }
//
//    class MainActivityAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val binding = AdapterRepoBinding.bind(itemView)
//    }
//
//    fun updateList(Repo: List<Repo>, oldCount: Int, tvShowListSize: Int) {
//        this.item = Repo
//        notifyDataSetChanged()
//        notifyItemRangeInserted(oldCount, tvShowListSize)
//    }
//
//    private fun setValues(holder: MainActivityAdapterHolder, repo: Repo){
//        holder.binding.repositoryName.text = repo.name
//        holder.binding.repositoryDescription.text = repo.description
//        holder.binding.repositoryForkCount.text = repo.forks_count.toString()
//        holder.binding.repositoryStarCount.text = repo.stargazers_count.toString()
//        holder.binding.ownerUsername.text = repo.owner.login
//
//        Glide.with(ctx)
//            .load(repo.owner.avatar_url)
//            .circleCrop()
//            .into(holder.binding.ownerPicture)
//
//        holder.itemView.setOnClickListener {
//            cellClickListener.onCellClickListener(repo)
//        }
//    }
//
//    private fun setAcessibility(holder: MainActivityAdapterHolder, repo: Repo){
//        holder.binding.repositoryName.contentDescription = ctx.getString(R.string.repository_name,repo.name)
//        holder.binding.repositoryDescription.contentDescription = ctx.getString(R.string.repository_description,repo.description)
//        holder.binding.repositoryForkCount.contentDescription = ctx.getString(R.string.forks_description,repo.forks_count.toString())
//        holder.binding.repositoryStarCount.contentDescription = ctx.getString(R.string.star_description,repo.stargazers_count.toString())
//        holder.binding.ownerUsername.contentDescription = ctx.getString(R.string.owner_description,repo.owner.login)
//        holder.binding.ownerPicture.contentDescription = ctx.getString(R.string.avatar_owner_description)
//    }
}