package com.br.apptest.domain.use_case

import com.br.apptest.data.repository.IRepository
import com.br.apptest.domain.model.Repositories

class ItemUseCase(private val repository: IRepository) : IItemUseCase {
    override suspend fun getRepositories(page: Int): Repositories = repository.getRespositories(page)
}

interface IItemUseCase {
    suspend fun getRepositories(page: Int): Repositories
}
