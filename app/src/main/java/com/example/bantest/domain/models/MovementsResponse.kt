package com.example.bantest.domain.models

import com.google.gson.annotations.SerializedName

data class MovementsResponse(
    val listMovements : List<MovementsModel>?
)
