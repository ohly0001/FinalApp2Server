package ktor.cst8410

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class LoginRequest(
    @SerialName("loginName")
    var loginName: String?,
    @SerialName("password")
    var password: String?
)