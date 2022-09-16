package com.br.apptest.data.repository

import com.br.apptest.data.api.Api
import com.br.apptest.domain.model.RepositoryVO
import com.br.apptest.domain.model.SystemVO
import com.br.apptest.util.Constants

class RepositoriesRepository(
    private val api: Api
): IRepository {
        override suspend fun getRespositories(page: Int): RepositoryVO {
            val response = api.getRepositories(Constants.language,Constants.sort,page.toString())
            if (response.isSuccessful) {
               return RepositoryVO(response.body()!!.items, SystemVO(0,""))
            }
            return RepositoryVO(listOf(), SystemVO(response.code(),response.message()))
        }
}
interface IRepository {
    suspend fun getRespositories(page: Int): RepositoryVO
}
