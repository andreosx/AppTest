package com.br.apptest.presenter.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.apptest.R
import com.br.apptest.databinding.ActivityMainBinding
import com.br.apptest.presenter.adapter.RepositoryListAdapter
import com.br.apptest.presenter.viewmodel.ItemListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RepositoryListAdapter
    private val viewModel by viewModel<ItemListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        showLoading()
        setView()
        viewModel.getItemList(1)
    }

    override fun onResume() {
        super.onResume()
        initObservable()
    }

    private fun initObservable(){
        viewModel.getList().observe(this, Observer {
            hiddenLoading()
            if (it != null) {
                adapter.itens = it
            }
        })

        viewModel.getError().observe(this, Observer {
            hiddenLoading()
            binding.recyclerView.visibility = View.GONE
            Toast.makeText(this@MainActivity,it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun setView(){
        adapter = RepositoryListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hiddenLoading(){
        binding.progressBar.visibility = View.GONE
    }

}
