package com.br.apptest.presenter.adapter.util

import com.br.apptest.domain.model.Item

interface CellClickListener {
    fun onCellClickListener(item: Item)
}