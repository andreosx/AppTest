package com.br.apptest.data.api

import com.br.apptest.data.model.PullResponse
import com.br.apptest.data.model.RepositoriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("repositories")
    suspend fun getRepositories(
        @Query("q") q: String?,
        @Query("sort") sort: String?,
        @Query("page") page: String?,
    ): Response<RepositoriesResponse>

    @GET("repos/{owner}/{repository}/pulls/1")
    suspend fun getPulls(
        @Path("owner") owner: String,
        @Path("repository") repository: String
    ):  Response<List<PullResponse>>
}