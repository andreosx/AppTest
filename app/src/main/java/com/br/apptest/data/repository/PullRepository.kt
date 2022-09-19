package com.br.apptest.data.repository

import com.br.apptest.data.api.Api
import com.br.apptest.data.model.toRepositories
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.domain.model.repo.SystemVO
import com.br.apptest.domain.model.pull.PullVO

class PullRepository(
    private val api: Api
): IPullRepository {
        override suspend fun getPull(owner: String, repo: String): PullVO {
            val response = api.getPulls(owner,repo)
            if (response.isSuccessful) {
               return PullVO(response.body()!!.toRepositories().items, SystemVO(0,""))
            }
            return PullVO(listOf(), SystemVO(response.code(),response.message()))
        }
}
interface IPullRepository {
    suspend fun getPull(owner: String, repo: String): PullVO
}
