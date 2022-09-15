package com.br.apptest.domain.use_case

import com.br.apptest.data.repository.IRepository
import com.br.apptest.domain.model.RepositoryItem
import com.br.apptest.domain.model.SystemVO

class GetRepositoryUseCase(private val repository: IRepository): IGetRepositoryUseCase {
    override suspend fun getRepository(page: Int): RepositoryItem = try {
        repository.getRepositories(page)
    } catch (ex: Exception){
        ex.printStackTrace()
        RepositoryItem(listOf(), SystemVO(422,""))
    }
}
interface IGetRepositoryUseCase{
    suspend fun getRepository(page: Int): RepositoryItem
}
