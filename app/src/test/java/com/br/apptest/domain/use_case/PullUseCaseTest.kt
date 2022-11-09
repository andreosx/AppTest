package com.br.apptest.domain.use_case

import com.br.apptest.data.model.PullResponse
import com.br.apptest.data.repository.PullRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class PullUseCaseTest{

    private val repository = mockk<PullRepository>()
    private val useCase = PullUseCase(repository)

    @Test
    fun getPull_return_list_with_success(){
        runBlocking {
            val response: Response<List<PullResponse>> = mockk()

            //Given
            coEvery { repository.getPull("andre","Kotlin") } returns response

            //When
            val result = useCase.getPull("andre","Kotlin")

            //Then
            Assert.assertEquals(result, response)

        }
    }
}
