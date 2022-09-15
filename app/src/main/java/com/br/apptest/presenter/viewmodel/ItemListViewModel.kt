package com.br.apptest.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.apptest.domain.model.Item
import com.br.apptest.domain.model.SystemVO
import com.br.apptest.domain.use_case.GetRepositoryUseCase
import com.br.apptest.domain.use_case.IGetRepositoryUseCase
import kotlinx.coroutines.*

class RepositoryListViewModel (private val getRepositoryUseCase: IGetRepositoryUseCase)  : ViewModel() {

    private val userList = MutableLiveData<List<Item>?>()
    private val errorMessage = MutableLiveData<SystemVO>()
    var job: Job? = null

    fun getRepository(page: Int) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = getRepositoryUseCase.getRepository(page)
            withContext(Dispatchers.Main) {
                if(response.systemVO.code == 0){
                    userList.postValue(response.item)
                }else{
                    errorMessage.postValue(response.systemVO)
                }
            }
        }
    }

    fun getUserList(): LiveData<List<Item>?> {
        return userList
    }

    fun getError(): LiveData<SystemVO> {
        return errorMessage
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}