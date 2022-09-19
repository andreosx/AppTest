package com.br.apptest.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.domain.model.repo.SystemVO
import com.br.apptest.domain.model.pull.PullItem
import com.br.apptest.domain.use_case.IPullUseCase
import kotlinx.coroutines.*

class PullsViewModel (private val useCase: IPullUseCase)  : ViewModel() {

    private val itemList = MutableLiveData<List<PullItem>>()
    private val errorMessage = MutableLiveData<SystemVO>()
    var job: Job? = null

    fun getPull(owner: String, repo: String) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = useCase.getPull(owner,repo)
            withContext(Dispatchers.Main) {
                if(response.systemVO.code == 0){
                    itemList.postValue(response.item)
                }else{
                    errorMessage.postValue(response.systemVO)
                }
            }
        }
    }

    fun getList(): LiveData<List<PullItem>> {
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