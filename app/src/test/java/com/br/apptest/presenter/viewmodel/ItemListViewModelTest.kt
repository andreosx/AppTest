package com.br.apptest.presenter.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.br.apptest.domain.model.Item
import com.br.apptest.domain.model.SystemVO
import com.br.apptest.domain.use_case.ItemUseCase
import com.br.apptest.factory.RepositoryVOFactory
import com.br.apptest.factory.SystemVOFactory
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch


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
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)

        viewModel.getList().observeForever(observeTodo)
        viewModel.getError().observeForever(observerError)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUsers_return_observable_with_success() = runTest{
        //Given
        coEvery { useCase.getRepositories(1) } returns RepositoryVOFactory.repositories

        //When
        viewModel.getItemList(1)

        //Then
        var allUsers : List<Item>? = RepositoryVOFactory.items
        val latch = CountDownLatch(1)
        val observer = object : Observer<List<Item>> {
            override fun onChanged(users: List<Item>?) {
                allUsers = users
                latch.countDown()
                viewModel.getList().removeObserver(this)
            }
        }

        viewModel.getList().observeForever(observer)
        assertNotNull(allUsers)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUsers_return_observable_with_error() = runTest{
        //Given
        coEvery { useCase.getRepositories(1) } returns RepositoryVOFactory.repositoriesErro

        //When
        viewModel.getItemList(1)

        //Then
        var systemVO : SystemVO? = SystemVOFactory.systemVOError
        val latch = CountDownLatch(1)
        val observer = object : Observer<SystemVO> {
            override fun onChanged(system: SystemVO?) {
                systemVO = system
                latch.countDown()
                viewModel.getError().removeObserver(this)
            }
        }

        viewModel.getError().observeForever(observer)
        assertNotNull(systemVO)
    }
}
