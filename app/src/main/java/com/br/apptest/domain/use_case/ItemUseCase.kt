package com.br.apptest.domain.use_case

import com.br.apptest.data.repository.IRepository
import com.br.apptest.domain.model.RepositoryVO
import com.br.apptest.domain.model.SystemVO

class ItemUseCase(private val repository: IRepository) : IItemUseCase {

    val MSG: String = "Exception!"

    override suspend fun getRepositories(page: Int): RepositoryVO = try{
        repository.getRespositories(page)
    }catch (ex: Exception){
        RepositoryVO(listOf(), SystemVO(500,MSG))
    }
}

interface IItemUseCase {
    suspend fun getRepositories(page: Int): RepositoryVO
}
