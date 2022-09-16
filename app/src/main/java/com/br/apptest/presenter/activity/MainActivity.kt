package com.br.apptest.presenter.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.apptest.R
import com.br.apptest.databinding.ActivityMainBinding
import com.br.apptest.domain.model.Item
import com.br.apptest.presenter.adapter.ItemListAdapter
import com.br.apptest.presenter.viewmodel.ItemListViewModel
import com.br.apptest.util.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemListAdapter
    private lateinit var listItem: MutableList<Item>

    private val viewModel by viewModel<ItemListViewModel>()

    private var currentPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setView()
        initObservable()
        getItemList(currentPage)
    }

    private fun initObservable(){
        viewModel.getList().observe(this, Observer {
            hiddenLoading()
            if (it != null){
                listItem.addAll(it)
                loadPageList(it)
            }
        })

        viewModel.getError().observe(this, Observer {
            hiddenLoading()
            binding.recyclerView.visibility = View.GONE
            Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun setView(){
        listItem = arrayListOf()
        adapter = ItemListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.recyclerView.canScrollVertically(1)) {
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

    private fun loadPageList(newItem: List<Item>) {
        hiddenLoading()
        val oldCount = listItem.size
        listItem.addAll(newItem)
        adapter.updateList(listItem, oldCount, listItem.size)
    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hiddenLoading(){
        binding.progressBar.visibility = View.GONE
    }

}
