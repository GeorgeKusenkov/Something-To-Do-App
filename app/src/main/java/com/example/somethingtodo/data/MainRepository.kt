package com.example.somethingtodo.data

import com.example.somethingtodo.entity.UsefulActivity
import javax.inject.Inject

class MainRepository@Inject constructor(
    private val usefulActivityDataSource: UsefulActivityDataSource
) {
    suspend fun getActivityInfo(): UsefulActivity {
        return usefulActivityDataSource.loadActivity()
    }
}