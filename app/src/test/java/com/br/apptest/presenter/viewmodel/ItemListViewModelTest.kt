package com.br.apptest.presenter.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.br.apptest.domain.model.Item
import com.br.apptest.domain.model.SystemVO
import com.br.apptest.domain.use_case.ItemUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule

class ItemListViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private val useCase = mockk<ItemUseCase>()
    private val viewModel = ItemListViewModel(useCase)

    private var observeTodo = mockk<Observer<List<Item>>>()
    private var observerError = mockk<Observer<SystemVO>>()

    @Before
    fun setup() {

        viewModel.getList().observeForever(observeTodo)
        viewModel.getError().observeForever(observerError)

        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

//    @Test
//    fun getRepositories_return_exception() {
//        runBlocking {
//            //Given
//            coEvery { useCase.getRepositories(1) } returns RepositoryVOFactory.repositories
//
//            //When
//            viewModel.getItemList(1)
//
//            //Then
//            verify(observeTodo).onChanged(RepositoryVOFactory.items)
//            verify(observerError).onChanged(RepositoryVOFactory.repositories.systemVO)
//        }
//    }
}
