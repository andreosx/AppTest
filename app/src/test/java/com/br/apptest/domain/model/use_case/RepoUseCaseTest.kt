package com.br.apptest.domain.model.use_case

import com.br.apptest.data.model.RepositoriesResponse
import com.br.apptest.data.repository.RepoRepository
import com.br.apptest.domain.model.repo.Repository
import com.br.apptest.factory.RepositoryFactory
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import retrofit2.Response

class RepoUseCaseTest : TestCase() {

    private val repository = mockk<RepoRepository>()
    private val useCase = RepoUseCase(repository)

    fun testGetRepositories() {

        runBlocking {
            val response: Response<RepositoriesResponse> = mockk()

            //Given
            coEvery { repository.getRespositories(1) } returns response

            //When
            val result = useCase.getRepositories(1)

            //Then
            Assert.assertEquals(result, response)

        }

    }

    fun testConvRepositories() {
        val repoResponse: RepositoriesResponse = RepositoryFactory.repositoryResponse
        val repoTest: Repository = RepositoryFactory.repository

        val repositoryConv = useCase.convRepositories(repoResponse)

        Assert.assertEquals(repositoryConv, repoTest)
    }
}