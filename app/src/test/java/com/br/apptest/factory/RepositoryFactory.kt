package com.br.apptest.factory

import com.br.apptest.data.model.RepositoriesResponse
import com.br.apptest.domain.model.repo.Repository

object RepositoryFactory {
    val repositoryResponse = RepositoriesResponse(false, listOf(),0)
    val repository = Repository(false, listOf(),0)
}