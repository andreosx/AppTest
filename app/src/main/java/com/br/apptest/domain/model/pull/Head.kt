package com.br.apptest.domain.model.pull

data class Head(
    val label: String,
    val ref: String,
    val repo: RepoX,
    val sha: String,
    val user: UserXX
)