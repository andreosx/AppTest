package com.br.apptest.data.repository

import com.br.apptest.data.api.Api
import com.br.apptest.data.model.PullResponse
import retrofit2.Response

class PullRepository(
    private val api: Api
): IPullRepository {
    override suspend fun getPull(owner: String, repo: String): Response<List<PullResponse>> {
        return api.getPulls(owner,repo)
    }
}
interface IPullRepository {
    suspend fun getPull(owner: String, repo: String): Response<List<PullResponse>>
}
