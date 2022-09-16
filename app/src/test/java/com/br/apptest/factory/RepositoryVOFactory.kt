package com.br.apptest.factory

import com.br.apptest.domain.model.RepositoryVO
import com.br.apptest.domain.model.SystemVO

object RepositoryVOFactory {

    val items =  listOf(
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
    )
    val repositories =  RepositoryVO(items, SystemVO(200,"Teste"))
}