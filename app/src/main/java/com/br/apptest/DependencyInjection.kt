package com.br.apptest

import com.br.apptest.data.api.Api
import com.br.apptest.data.repository.IRepository
import com.br.apptest.data.repository.RepositoriesRepository
import com.br.apptest.domain.use_case.ItemUseCase
import com.br.apptest.domain.use_case.IItemUseCase
import com.br.apptest.presenter.viewmodel.ItemListViewModel
import com.br.apptest.util.retrofit.Service
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModule = module {

    single { Service().createService(Api::class.java) }

    factory<IRepository> { RepositoriesRepository(get()) }

    factory<IItemUseCase> { ItemUseCase(get()) }

    viewModel { ItemListViewModel(get()) }
}

