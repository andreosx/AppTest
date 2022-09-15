package com.picpay.desafio.android

import com.br.apptest.data.api.Api
import com.br.apptest.data.repository.IRepository
import com.br.apptest.data.repository.GitRepository
import com.br.apptest.domain.use_case.ItemUseCase
import com.br.apptest.domain.use_case.IItemUseCase
import com.br.apptest.presenter.viewmodel.ItemListViewModel
import com.br.apptest.util.retrofit.Service
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModule = module {

    single { Service().createService(Api::class.java) }

    factory<IRepository> { GitRepository(get()) }

    factory<IItemUseCase> { ItemUseCase(get()) }

    viewModel { ItemListViewModel(get()) }
}

