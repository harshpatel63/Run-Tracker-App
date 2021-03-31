package com.example.runtrackerapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runtrackerapp.repositories.MainRepository
import com.example.runtrackerapp.roomDB.entities.Run
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {


    fun insertRun(run : Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }

}