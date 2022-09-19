package com.br.apptest

import com.br.apptest.data.api.Api
import com.br.apptest.data.repository.IPullRepository
import com.br.apptest.data.repository.IRepoRepository
import com.br.apptest.data.repository.PullRepository
import com.br.apptest.data.repository.RepoRepository
import com.br.apptest.domain.use_case.PullUseCase
import com.br.apptest.domain.use_case.IPullUseCase
import com.br.apptest.domain.use_case.IRepoUseCase
import com.br.apptest.domain.use_case.RepoUseCase
import com.br.apptest.presenter.viewmodel.RepoViewModel
import com.br.apptest.presenter.viewmodel.PullsViewModel
import com.br.apptest.util.retrofit.Service
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModule = module {

    single { Service().createService(Api::class.java) }

    factory<IRepoRepository> { RepoRepository(get()) }

    factory<IRepoUseCase> { RepoUseCase(get()) }

    factory<IPullRepository> { PullRepository(get()) }

    factory<IPullUseCase> { PullUseCase(get()) }

    viewModel { RepoViewModel(get()) }

    viewModel { PullsViewModel(get()) }
}

