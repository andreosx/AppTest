package com.br.apptest.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.R
import com.br.apptest.databinding.AdapterPullBinding
import com.br.apptest.domain.model.pull.PullItem

class PullAdapter(val ctx: Context) :
    RecyclerView.Adapter<PullAdapter.MainActivityAdapterHolder>() {

    private var item = emptyList<PullItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityAdapterHolder {
        return MainActivityAdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_pull, parent, false))
    }

    override fun onBindViewHolder(holder: MainActivityAdapterHolder, position: Int) {
        setValues(holder,item[position])
        setAcessibility(holder,item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    class MainActivityAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = AdapterPullBinding.bind(itemView)
    }

    fun updateList(Repo: List<PullItem>, oldCount: Int, tvShowListSize: Int) {
        this.item = Repo
        notifyDataSetChanged()
        notifyItemRangeInserted(oldCount, tvShowListSize)
    }

    private fun setValues(holder: MainActivityAdapterHolder, pull: PullItem){
        holder.binding.pullTitle.text = pull.title
        holder.binding.pullDescription.text = pull.body
        holder.binding.ownerUsername.text = pull.user.login

    }

    private fun setAcessibility(holder: MainActivityAdapterHolder, pull: PullItem){
        holder.binding.pullTitle.contentDescription = pull.title
        holder.binding.pullDescription.contentDescription = pull.body
        holder.binding.ownerUsername.contentDescription = pull.user.login
    }
}