package com.br.apptest.domain.use_case

import com.br.apptest.data.model.PullResponse
import com.br.apptest.data.repository.IPullRepository
import retrofit2.Response

class PullUseCase(private val pullRepository: IPullRepository) : IPullUseCase {
    override suspend fun getPull(owner: String, repo: String): Response<List<PullResponse>> = pullRepository.getPull(owner,repo)
}

interface IPullUseCase {
    suspend fun getPull(owner: String, repo: String): Response<List<PullResponse>>
}
