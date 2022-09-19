package com.br.apptest.factory

import com.br.apptest.domain.model.repo.RepositoryVO

object RepositoryVOFactory {

    val items =  listOf(
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
    )
    val repositories =  RepositoryVO(items, SystemVOFactory.systemVOSuccess)

    val repositoriesErro = RepositoryVO(listOf(), SystemVOFactory.systemVOError)

}