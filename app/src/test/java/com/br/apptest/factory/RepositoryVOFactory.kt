package com.br.apptest.factory

import com.br.apptest.data.model.RepositoriesResponse
import com.br.apptest.domain.model.repo.RepositoryVO
import com.br.apptest.domain.model.util.SystemDTO
import okhttp3.Protocol
import okhttp3.Request
import retrofit2.Response

object RepositoryVOFactory {

    val items =  listOf(
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
       ItemFactory.item,
    )
    val repositories =  RepositoriesResponse(true, items,5)

    val repositoriesSuccess: Response<RepositoriesResponse> =
        Response.success(repositories,
            okhttp3.Response.Builder()
                .code(200)
                .message("Response.success()")
                .protocol(Protocol.HTTP_1_1)
                .request(Request.Builder().url("http://test-url/").build())
                .receivedResponseAtMillis(1619053449513)
                .sentRequestAtMillis(1619053443814)
                .build())

    val repositoriesError: Response<SystemDTO> =
        Response.success(SystemVOFactory.systemVOError,
            okhttp3.Response.Builder()
                .code(500)
                .message("Response.error()")
                .protocol(Protocol.HTTP_1_1)
                .request(Request.Builder().url("http://test-url/").build())
                .receivedResponseAtMillis(1619053449513)
                .sentRequestAtMillis(1619053443814)
                .build())

}