package com.br.apptest.domain.use_case

import com.br.apptest.data.repository.PullRepository
import com.br.apptest.factory.RepositoryVOFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class PullUseCaseTest{

    private val repository = mockk<PullRepository>()
    private val useCase = PullUseCase(repository)

    @Test
    fun getRepositories_return_list_with_success(){
//        runBlocking {
//            //Given
//            coEvery { repository.getPull("andre","java") } returns RepositoryVOFactory.repositories
//
//            //When
//            val result = useCase.getPull(1).item
//
//            //Then
//            Assert.assertEquals(result.size, RepositoryVOFactory.repositories.Repo.size)
//
//        }
    }

    @Test
    fun getRepositories_return_exception(){
//        runBlocking {
//            //Given
//            coEvery { repository.getRespositories(1) } throws RuntimeException()
//
//            //When
//            val result = useCase.getPull(1)
//
//            //Then
//            Assert.assertEquals(result.item.size,0)
//
//        }
    }
}