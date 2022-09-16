package com.br.apptest.factory

import com.br.apptest.domain.model.SystemVO

object SystemVOFactory {
    val systemVOError = SystemVO(500,"Erro")
    val systemVOSuccess = SystemVO(200,"")
}