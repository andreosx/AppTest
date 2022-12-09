package com.br.apptest.domain.use_case

import com.br.apptest.data.model.RepositoriesResponse
import com.br.apptest.data.model.toRepositories
import com.br.apptest.data.repository.IRepoRepository
import com.br.apptest.domain.model.repo.Repository
import retrofit2.Response

class RepoUseCase(private val pullRepo: IRepoRepository) : IRepoUseCase {
    override suspend fun getRepositories(page: Int): Response<RepositoriesResponse> = pullRepo.getRespositories(page)

    override fun convRepositories(repoResponse: RepositoriesResponse): Repository {
        return repoResponse.toRepositories()
    }
}

interface IRepoUseCase {
    suspend fun getRepositories(page: Int): Response<RepositoriesResponse>
    fun convRepositories(repoResponse: RepositoriesResponse): Repository
}
