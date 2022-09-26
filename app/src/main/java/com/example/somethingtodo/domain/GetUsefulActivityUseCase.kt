package com.example.somethingtodo.domain

import com.example.somethingtodo.data.MainRepository
import com.example.somethingtodo.entity.UsefulActivity
import javax.inject.Inject

class GetUsefulActivityUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
        suspend fun execute(): UsefulActivity {
            return mainRepository.getActivityInfo()
        }
}