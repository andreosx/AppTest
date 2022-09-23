package com.br.apptest.factory

import com.br.apptest.domain.model.util.SystemDTO

object SystemVOFactory {
    val systemVOError = SystemDTO(500, "Erro")
    val systemVOSuccess = SystemDTO(200, "")
}