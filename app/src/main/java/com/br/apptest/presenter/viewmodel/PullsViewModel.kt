package com.br.apptest.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.apptest.data.model.PullResponse
import com.br.apptest.domain.model.util.SystemDTO
import com.br.apptest.domain.use_case.IPullUseCase
import com.br.apptest.util.Output
import com.br.apptest.util.parseResponse
import kotlinx.coroutines.*

class PullsViewModel (private val useCase: IPullUseCase)  : ViewModel() {

    private val itemList = MutableLiveData<List<PullResponse>>()
    private val errorMessage = MutableLiveData<SystemDTO>()
    var job: Job? = null

    fun getPull(owner: String, repo: String) {
        job = CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                when(val response = useCase.getPull(owner,repo).parseResponse()){
                    is Output.Success -> itemList.postValue(response.value!!)
                    is Output.Failure -> errorMessage.postValue(SystemDTO(
                        response.statusCode,
                        response.message
                    )
                    )
                }
            }
        }
    }

    fun getList(): LiveData<List<PullResponse>> {
        return itemList
    }

    fun getError(): LiveData<SystemDTO> {
        return errorMessage
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}