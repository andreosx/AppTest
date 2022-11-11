package com.br.apptest.data.repository

import com.br.apptest.data.api.Api
import com.br.apptest.data.model.RepositoriesResponse
import com.br.apptest.util.Constants
import retrofit2.Response

class RepoRepository(private val api: Api) : IRepoRepository {
    override suspend fun getRespositories(page: Int): Response<RepositoriesResponse> {
        return api.getRepositories(Constants.language, Constants.sort, page.toString())
    }
}

interface IRepoRepository {
    suspend fun getRespositories(page: Int): Response<RepositoriesResponse>
}
