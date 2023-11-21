package com.example.bantest.domain.models

import com.google.gson.annotations.SerializedName

data class MovementsModel(
    @SerializedName("pkMovimientosID") val idMovement: Int,
    @SerializedName("Descripcion") val description: String,
    @SerializedName("Fecha") val date: String,
    @SerializedName("Monto") val amount: String)
