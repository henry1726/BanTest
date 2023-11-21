package com.example.bantest.domain.usecases

import com.example.bantest.commons.Resource
import com.example.bantest.domain.models.InfoTDCResponse
import com.example.bantest.domain.repository.BanRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetInfoTDCUseCase @Inject constructor(
    private val banRepository: BanRepository
){
    fun getInfoTDC() : Flow<Resource<InfoTDCResponse?>> = banRepository.getInfoTDC()
}