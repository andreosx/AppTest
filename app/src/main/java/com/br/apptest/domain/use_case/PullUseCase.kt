package com.br.apptest.domain.use_case

import com.br.apptest.data.repository.IPullRepository
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.domain.model.repo.SystemVO
import com.br.apptest.domain.model.pull.PullVO

class PullUseCase(private val pullRepository: IPullRepository) : IPullUseCase {

    val MSG: String = "Exception!"

    override suspend fun getPull(owner: String, repo: String): PullVO = try{
        pullRepository.getPull(owner,repo)
    }catch (ex: Exception){
        ex.printStackTrace()
        PullVO(listOf(), SystemVO(500,MSG))
    }
}

interface IPullUseCase {
    suspend fun getPull(owner: String, repo: String): PullVO
}
