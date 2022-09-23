package com.br.apptest.presenter.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.apptest.R
import com.br.apptest.databinding.ActivityPullBinding
import com.br.apptest.domain.model.pull.PullItem
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.presenter.adapter.PullAdapter
import com.br.apptest.presenter.viewmodel.PullsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PullsActivity : AppCompatActivity(R.layout.activity_pull) {

    private lateinit var binding: ActivityPullBinding
    private lateinit var adapter: PullAdapter
    private lateinit var listRepo: MutableList<PullItem>
    private lateinit var owner: String
    private lateinit var repo: String

    private val viewModel by viewModel<PullsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_pull)
        owner = intent.getStringExtra("owner")!!
        repo = intent.getStringExtra("repo")!!

        setView()
        initObservable()
        getPull(owner,repo)

    }

    private fun initObservable(){
        viewModel.getList().observe(this, Observer {
            hiddenLoading()
            if (it != null){
               // listRepo.addAll(it)
               // loadPageList(it)
            }
        })

        viewModel.getError().observe(this, Observer {
            hiddenLoading()
            Toast.makeText(this,it.message, Toast.LENGTH_LONG).show()
            finish()
        })
    }

    private fun setView(){
        listRepo = arrayListOf()
        adapter = PullAdapter(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getPull(owner: String, repo: String){
        showLoading()
        viewModel.getPull(owner,repo)
    }

    private fun loadPageList(newRepo: List<PullItem>) {
        hiddenLoading()
        val oldCount = listRepo.size
        listRepo.addAll(newRepo)
        adapter.updateList(listRepo, oldCount, listRepo.size)
    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hiddenLoading(){
        binding.progressBar.visibility = View.GONE
    }

    companion object {
        fun createIntent(repo: Repo, context: Context): Intent {
            val intent = Intent(context, PullsActivity::class.java)
            intent.putExtra("owner", repo.owner.login)
            intent.putExtra("repo", repo.language)
            return intent
        }
    }

}
