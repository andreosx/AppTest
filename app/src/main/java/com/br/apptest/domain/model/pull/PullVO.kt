package com.br.apptest.domain.model.pull

import com.br.apptest.domain.model.repo.SystemVO
import kotlinx.parcelize.RawValue

data class PullVO(
    val item: @RawValue List<PullItem>,
    val systemVO: SystemVO
    )