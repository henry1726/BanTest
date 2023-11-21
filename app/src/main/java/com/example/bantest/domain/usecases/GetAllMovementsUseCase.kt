package com.example.bantest.domain.usecases

import com.example.bantest.commons.Resource
import com.example.bantest.domain.models.MovementsResponse
import com.example.bantest.domain.repository.BanRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMovementsUseCase @Inject constructor(
    private val banRepository: BanRepository
){
    fun getAllMovements() : Flow<Resource<MovementsResponse?>> = banRepository.getAllMovements()
}