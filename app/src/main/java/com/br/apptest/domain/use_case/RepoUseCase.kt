package com.br.apptest.domain.use_case

import com.br.apptest.data.model.RepositoriesResponse
import com.br.apptest.data.repository.IRepoRepository
import retrofit2.Response

class RepoUseCase(private val pullRepo: IRepoRepository) : IRepoUseCase {
    override suspend fun getRepositories(page: Int): Response<RepositoriesResponse> = pullRepo.getRespositories(page)
}

interface IRepoUseCase {
    suspend fun getRepositories(page: Int): Response<RepositoriesResponse>
}
