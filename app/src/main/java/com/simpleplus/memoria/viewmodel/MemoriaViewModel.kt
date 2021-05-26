package com.simpleplus.memoria.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.simpleplus.memoria.model.Memoria
import com.simpleplus.memoria.repository.MemoriaRepository
import kotlinx.coroutines.launch

class MemoriaViewModel (private val repo:MemoriaRepository):ViewModel() {

    val allMemoria = repo.allMemoria.asLiveData()


    fun insert(memoria:Memoria) = viewModelScope.launch { repo.insert(memoria) }

    fun update(memoria:Memoria) = viewModelScope.launch { repo.update(memoria) }

    fun delete(memoria:Memoria) = viewModelScope.launch { repo.delete(memoria) }

    fun deleteAll() = viewModelScope.launch { repo.deleteAll() }

}

class MemoriaViewModelFactory (private val repo: MemoriaRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MemoriaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MemoriaViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }


}