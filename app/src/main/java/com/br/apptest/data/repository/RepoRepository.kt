package com.br.apptest.data.repository

import com.br.apptest.data.api.Api
import com.br.apptest.data.model.toRepositories
import com.br.apptest.domain.model.repo.RepositoryVO
import com.br.apptest.domain.model.repo.SystemVO
import com.br.apptest.util.Constants

class RepoRepository(
    private val api: Api
): IRepoRepository {
        override suspend fun getRespositories(page: Int): RepositoryVO {
            val response = api.getRepositories(Constants.language,Constants.sort,page.toString())
            if (response.isSuccessful) {
               return RepositoryVO(response.body()!!.toRepositories().Repos, SystemVO(0,""))
            }
            return RepositoryVO(listOf(), SystemVO(response.code(),response.message()))
        }
}
interface IRepoRepository {
    suspend fun getRespositories(page: Int): RepositoryVO
}
