package com.example.somethingtodo.data

import com.example.somethingtodo.data.api.RetrofitServices
import javax.inject.Inject

class UsefulActivityDataSource @Inject constructor() {
    suspend fun loadActivity(): UsefulActivityDto {
        val activityFromApi = RetrofitServices.somethingToDoApi.getActivity().activity
        return UsefulActivityDto(
            activity = activityFromApi
        )
    }
}