package com.example.bantest.domain.api

import com.example.bantest.domain.models.InfoTDCResponse
import com.example.bantest.domain.models.MovementsResponse
import retrofit2.http.GET
import retrofit2.Response

interface BanRegioApiService {
    @GET("/rest/tarjetacredito.php/1")
    suspend fun getInfoTDC() : Response<InfoTDCResponse>


    @GET("/rest/tarjetacredito-movimientos.php/3")
    suspend fun getAllMovementsTDC() : Response<MovementsResponse>
}