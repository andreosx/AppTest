package com.br.apptest.domain.model.pull

data class Base(
    val label: String,
    val ref: String,
    val repo: Repo,
    val sha: String,
    val user: UserXX
)