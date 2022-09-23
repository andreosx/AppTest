package com.br.apptest.domain.model.pull

import com.br.apptest.domain.model.util.SystemDTO
import kotlinx.parcelize.RawValue

data class PullVO(
    val item: @RawValue List<PullItem>,
    val systemDTO: SystemDTO
    )