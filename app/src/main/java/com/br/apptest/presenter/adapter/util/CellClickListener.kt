package com.br.apptest.presenter.adapter.util

import com.br.apptest.domain.model.repo.Repo

interface CellClickListener {
    fun onCellClickListener(repo: Repo)
}