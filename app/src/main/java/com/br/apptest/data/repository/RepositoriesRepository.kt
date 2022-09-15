package com.br.apptest.data.repository

import com.br.apptest.data.api.Api
import com.br.apptest.domain.model.Git
import com.br.apptest.domain.model.SystemVO
import com.br.apptest.util.Constants

class GitRepository(
    private val api: Api
): IRepository {
        override suspend fun getRepositorie(page: Int): Git {
            val response = api.getRepositories(Constants.language,Constants.sort,page.toString())
            if (response.isSuccessful) {
               return Git(response.body()?.items, SystemVO(0,""))
            }
            return Git(listOf(), SystemVO(response.code(),response.message()))
        }
}
interface IRepository {
    suspend fun getRepositorie(page: Int): Git
}
