package com.br.apptest.domain.model

import kotlinx.parcelize.RawValue

data class RepositoryVO(
    val item: @RawValue List<Item>,
    val systemVO: SystemVO
    )