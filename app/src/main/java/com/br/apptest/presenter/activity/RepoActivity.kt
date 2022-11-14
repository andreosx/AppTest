package com.br.apptest.presenter.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.R
import com.br.apptest.databinding.ActivityRepoBinding
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.presenter.adapter.RepoAdapter
import com.br.apptest.presenter.adapter.util.CellClickListener
import com.br.apptest.presenter.viewmodel.RepoViewModel
import com.br.apptest.util.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoActivity : AppCompatActivity(R.layout.activity_repo), CellClickListener {

    private lateinit var binding: ActivityRepoBinding
    private lateinit var adapter: RepoAdapter
    private lateinit var listRepo: MutableList<Repo>

    private val viewModel by viewModel<RepoViewModel>()

    private var currentPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_repo)

        setView()
        initObservable()
        getItemList(currentPage)
    }

    private fun initObservable(){
        viewModel.getList().observe(this) {
            hiddenLoading()
            if (it != null) {
                listRepo.addAll(it)
                loadPageList(it)
            }
        }

        viewModel.getError().observe(this) {
            hiddenLoading()
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setView(){
        listRepo = arrayListOf()
        adapter = RepoAdapter(this,this)
        binding.rvRepository.adapter = adapter
        binding.rvRepository.layoutManager = LinearLayoutManager(this)

        binding.rvRepository.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.rvRepository.canScrollVertically(1)) {
                    if (currentPage <= Constants.totalAvailablePages) {
                        currentPage += 1
                        getItemList(currentPage)
                    }
                }
            }
        })
    }

    private fun getItemList(page: Int){
        showLoading()
        viewModel.getItemList(page)
    }

    private fun loadPageList(newRepo: List<Repo>) {
        hiddenLoading()
        val oldCount = listRepo.size
        listRepo.addAll(newRepo)
        adapter.updateList(listRepo, oldCount, listRepo.size)
    }

    private fun showLoading(){
        binding.pbRepository.visibility = View.VISIBLE
    }

    private fun hiddenLoading(){
        binding.pbRepository.visibility = View.GONE
    }

    override fun onCellClickListener(repo: Repo) {
        Toast.makeText(this,repo.full_name,Toast.LENGTH_LONG).show()
    }

}
