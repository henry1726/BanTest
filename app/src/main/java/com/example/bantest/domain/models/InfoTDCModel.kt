package com.example.bantest.domain.models

import com.google.gson.annotations.SerializedName

data class InfoTDCModel(@SerializedName("pkTarjetaCreditoID") val idCreditCard: Int,
                        @SerializedName("Nombre_Banco") val bankName: String,
                        @SerializedName("Numero_Tarjeta") val cardName: String,
                        @SerializedName("Titular_Tarjeta") val cardHolder: String,
                        @SerializedName("Fecha_Exp") val expectationDate: String,
                        @SerializedName("CVV") val cvv: String)
