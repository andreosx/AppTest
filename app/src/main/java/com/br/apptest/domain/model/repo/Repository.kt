package com.br.apptest.domain.model.repo

data class Repository (
    val incomplete_results: Boolean,
    val Repos: List<Repo>,
    val total_count: Int
)
