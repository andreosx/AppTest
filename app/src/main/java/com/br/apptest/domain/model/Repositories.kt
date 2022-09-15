package com.br.apptest.domain.model

import kotlinx.parcelize.RawValue

data class Repositories(
    val item: @RawValue List<Item>?,
    val systemVO: SystemVO
    )