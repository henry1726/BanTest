package com.example.bantest.data

import com.example.bantest.commons.Resource
import com.example.bantest.domain.api.BanRegioApiService
import com.example.bantest.domain.models.InfoTDCResponse
import com.example.bantest.domain.models.MovementsResponse
import com.example.bantest.domain.repository.BanRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BanRepositoryImpl @Inject constructor(
    private val apiService: BanRegioApiService
) : BanRepository{
    override fun getInfoTDC(): Flow<Resource<InfoTDCResponse?>>  = flow{
        val result = apiService.getInfoTDC().run {
            if (isSuccessful)
                Resource.success(body())
            else
                Resource.error(errorBody().toString())
        }
        emit(result)
    }

    override fun getAllMovements(): Flow<Resource<MovementsResponse?>> = flow{
        val result = apiService.getAllMovementsTDC().run {
            if (isSuccessful)
                Resource.success(body())
            else
                Resource.error(errorBody().toString())
        }
        emit(result)
    }
}