package ktor.cst8410

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

enum class Operator {
    ADD, SUB, MUL, DIV
}

@Serializable
data class ArithmeticRequest(
    @SerialName("op")
    val op: Operator,
    @SerialName("a")
    val a: Float,
    @SerialName("b")
    val b: Float
)