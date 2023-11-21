package com.example.bantest.domain.repository

import com.example.bantest.commons.Resource
import com.example.bantest.domain.models.InfoTDCResponse
import com.example.bantest.domain.models.MovementsResponse
import kotlinx.coroutines.flow.Flow

interface BanRepository {

    fun getInfoTDC() : Flow<Resource<InfoTDCResponse?>>

    fun getAllMovements(): Flow<Resource<MovementsResponse?>>

}