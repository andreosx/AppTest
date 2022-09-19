package com.br.apptest.data.api

import com.br.apptest.data.model.RepositoriesResponse
import com.br.apptest.data.model.PullResponse
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

    @GET("repos/{owner}/{repository}/pulls")
    suspend fun getPulls(
        @Path("owner") owner: String,
        @Path("repository") repository: String
    ): Response<PullResponse>
}