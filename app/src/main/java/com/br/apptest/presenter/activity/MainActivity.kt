package com.picpay.desafio.android.presenter.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.presenter.adapter.UserListAdapter
import com.picpay.desafio.android.presenter.viewmodel.UserListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserListAdapter
    private val viewModel by viewModel<UserListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        showLoading()
        setView()
        viewModel.getUsers()
    }

    override fun onResume() {
        super.onResume()
        initObservable()
    }

    private fun initObservable(){
        viewModel.getUserList().observe(this, Observer {
            hiddenLoading()
            adapter.users = it
        })

        viewModel.getError().observe(this, Observer {
            hiddenLoading()
            binding.recyclerView.visibility = View.GONE
            Toast.makeText(this@MainActivity, getString(R.string.error), Toast.LENGTH_SHORT).show()
        })
    }

    private fun setView(){
        adapter = UserListAdapter()
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
