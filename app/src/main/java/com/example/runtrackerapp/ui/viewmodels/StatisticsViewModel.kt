package com.example.runtrackerapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.runtrackerapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {
}