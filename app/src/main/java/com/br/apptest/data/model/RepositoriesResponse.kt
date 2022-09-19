package com.br.apptest.data.model

import android.os.Parcelable
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.domain.model.repo.Repository
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class RepositoriesResponse(
    @SerializedName("incomplete_results") val incomplete_results: Boolean,
    @SerializedName("items") var Repos: @RawValue List<Repo>,
    @SerializedName("total_count") val total_count: Int
): Parcelable

fun RepositoriesResponse.toRepositories(): Repository {
    return Repository(
        Repos = Repos
    )
}

