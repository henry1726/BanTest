package com.example.bantest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bantest.commons.Resource
import com.example.bantest.domain.models.InfoTDCModel
import com.example.bantest.domain.models.InfoTDCResponse
import com.example.bantest.domain.models.MovementsResponse
import com.example.bantest.domain.usecases.GetAllMovementsUseCase
import com.example.bantest.domain.usecases.GetInfoTDCUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InforCardViewModel @Inject constructor(
    private val getAllMovementsUseCase: GetAllMovementsUseCase,
    private val getInfoTDCUseCase: GetInfoTDCUseCase
) : ViewModel() {

    private val _responseGetInfoTDC = MutableLiveData<Resource<InfoTDCResponse?>>()

    val responseGetInfoTDC get() = _responseGetInfoTDC

    private val _responseGetAllMovements = MutableLiveData<Resource<MovementsResponse?>>()

    val responseGetAllMovements get() = _responseGetAllMovements


    fun getInfoTDC() = viewModelScope.launch{
        getInfoTDCUseCase.getInfoTDC().collect{
            responseGetInfoTDC.value = it
        }
    }

    fun getAllMovements() = viewModelScope.launch {
        getAllMovementsUseCase.getAllMovements().collect{
            responseGetAllMovements.value = it
        }
    }
}