package com.br.apptest.domain.model

data class Repository (
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)
