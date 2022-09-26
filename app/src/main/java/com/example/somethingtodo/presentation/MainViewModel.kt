package com.example.somethingtodo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.somethingtodo.domain.GetUsefulActivityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getUsefulActivityUseCase: GetUsefulActivityUseCase): ViewModel() {
    private var _activityText = MutableStateFlow("What you're doing today?")
    val activityText = _activityText.asStateFlow()

    fun reloadUsefulActivity() {
        viewModelScope.launch {
            val person = getUsefulActivityUseCase.execute()
            _activityText.value = person.activity
        }
    }
}