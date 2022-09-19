package com.br.apptest.domain.use_case

import com.br.apptest.data.repository.IRepoRepository
import com.br.apptest.domain.model.repo.RepositoryVO
import com.br.apptest.domain.model.repo.SystemVO

class RepoUseCase(private val pullRepo: IRepoRepository) : IRepoUseCase {

    val MSG: String = "Exception!"

    override suspend fun getRepositories(page: Int): RepositoryVO = try{
        pullRepo.getRespositories(page)
    }catch (ex: Exception){
        RepositoryVO(listOf(), SystemVO(500,MSG))
    }
}

interface IRepoUseCase {
    suspend fun getRepositories(page: Int): RepositoryVO
}
