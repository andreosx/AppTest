package com.br.apptest.domain.model.repo

import kotlinx.parcelize.RawValue

data class RepositoryVO(
    val Repo: @RawValue List<Repo>,
    val systemVO: SystemVO
    )