package com.br.apptest.domain.use_case

import com.br.apptest.data.repository.RepositoriesRepository
import com.br.apptest.factory.RepositoryVOFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ItemUseCaseTest{

    private val repository = mockk<RepositoriesRepository>()
    private val useCase = ItemUseCase(repository)

    @Test
    fun getRepositories_return_list_with_success(){
        runBlocking {
            //Given
            coEvery { repository.getRespositories(1) } returns RepositoryVOFactory.repositories

            //When
            val result = useCase.getRepositories(1).item

            //Then
            Assert.assertEquals(result.size, RepositoryVOFactory.repositories.item.size)

        }
    }

    @Test
    fun getRepositories_return_exception(){
        runBlocking {
            //Given
            coEvery { repository.getRespositories(1) } throws RuntimeException()

            //When
            val result = useCase.getRepositories(1)

            //Then
            Assert.assertEquals(result.item.size,0)

        }
    }
}