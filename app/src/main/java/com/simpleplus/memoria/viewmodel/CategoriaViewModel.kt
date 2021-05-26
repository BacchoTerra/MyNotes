package com.simpleplus.memoria.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.simpleplus.memoria.model.Categoria
import com.simpleplus.memoria.repository.CategoriaRepository
import kotlinx.coroutines.launch

class CategoriaViewModel (private val repo:CategoriaRepository) : ViewModel() {


    val allCategorias = repo.allCategory.asLiveData()

    fun insert (categoria: Categoria) = viewModelScope.launch { repo.insert(categoria)}

    fun update (categoria: Categoria) = viewModelScope.launch { repo.update(categoria)}

    fun delete (categoria: Categoria) = viewModelScope.launch { repo.delete(categoria)}

    fun deleteAll () = viewModelScope.launch { repo.deleteAll()}

}

class CategoriaViewModelFactory(private val repo:CategoriaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(CategoriaViewModel::class.java)) {
            return CategoriaViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}