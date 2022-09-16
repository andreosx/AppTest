package com.br.apptest.data.model

import android.os.Parcelable
import com.br.apptest.domain.model.Item
import com.br.apptest.domain.model.Repository
import com.br.apptest.domain.model.RepositoryVO
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class RepositoriesResponse(
    @SerializedName("incomplete_results") val incomplete_results: Boolean,
    @SerializedName("items") var items: @RawValue List<Item>,
    @SerializedName("total_count") val total_count: Int
): Parcelable

fun RepositoriesResponse.toRepositories(): Repository {
    return Repository(
        items = items
    )
}

