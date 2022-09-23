package com.br.apptest.domain.model.repo

import com.br.apptest.domain.model.util.SystemDTO
import kotlinx.parcelize.RawValue

data class RepositoryVO(
    val Repo: @RawValue List<Repo>,
    val systemDTO: SystemDTO
    )