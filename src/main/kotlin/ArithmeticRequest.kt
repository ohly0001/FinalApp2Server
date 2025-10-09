package ktor.cst8410

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArithmeticRequest(
    @SerialName("op")
    val op: String,
    @SerialName("a")
    val a: Float,
    @SerialName("b")
    val b: Float
)