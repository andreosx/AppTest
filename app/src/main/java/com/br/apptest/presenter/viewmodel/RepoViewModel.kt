package com.br.apptest.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.domain.model.repo.SystemVO
import com.br.apptest.domain.use_case.IRepoUseCase
import kotlinx.coroutines.*

class RepoViewModel (private val useCase: IRepoUseCase)  : ViewModel() {

    private val itemList = MutableLiveData<List<Repo>>()
    private val errorMessage = MutableLiveData<SystemVO>()
    var job: Job? = null

    fun getItemList(page: Int) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = useCase.getRepositories(page)
            withContext(Dispatchers.Main) {
                if(response.systemVO.code == 0){
                    itemList.postValue(response.Repo)
                }else{
                    errorMessage.postValue(response.systemVO)
                }
            }
        }
    }

    fun getList(): LiveData<List<Repo>> {
        return itemList
    }

    fun getError(): LiveData<SystemVO> {
        return errorMessage
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}