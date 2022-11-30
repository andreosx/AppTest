package com.br.apptest.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.apptest.domain.model.repo.Repo
import com.br.apptest.domain.model.util.SystemDTO
import com.br.apptest.use_case.IRepoUseCase
import com.br.apptest.util.Output
import com.br.apptest.util.parseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepoViewModel(private val useCase: IRepoUseCase) : ViewModel() {

    private val itemList = MutableLiveData<List<Repo>>()
    private val errorMessage = MutableLiveData<SystemDTO>()

    fun getItemList(page: Int) {
       viewModelScope.launch {
            withContext(Dispatchers.Main) {
                when (val response = useCase.getRepositories(page).parseResponse()) {
                    is Output.Success -> itemList.postValue(useCase.convRepositories(response.value).Repos)
                    is Output.Failure -> errorMessage.postValue(
                        SystemDTO(
                            response.statusCode, response.message
                        )
                    )
                }
            }
        }
    }

    fun getList(): LiveData<List<Repo>> {
        return itemList
    }

    fun getError(): LiveData<SystemDTO> {
        return errorMessage
    }

}