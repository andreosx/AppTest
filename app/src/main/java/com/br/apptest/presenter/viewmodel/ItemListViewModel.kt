package com.br.apptest.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.apptest.domain.model.Item
import com.br.apptest.domain.model.SystemVO
import com.br.apptest.domain.use_case.IItemUseCase
import kotlinx.coroutines.*

class ItemListViewModel (private val useCase: IItemUseCase)  : ViewModel() {

    private val itemList = MutableLiveData<List<Item>?>()
    private val errorMessage = MutableLiveData<SystemVO>()
    var job: Job? = null

    fun getItemList(page: Int) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = useCase.getRepositories(page)
            withContext(Dispatchers.Main) {
                if(response.systemVO.code == 0){
                    itemList.postValue(response.item)
                }else{
                    errorMessage.postValue(response.systemVO)
                }
            }
        }
    }

    fun getList(): LiveData<List<Item>?> {
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