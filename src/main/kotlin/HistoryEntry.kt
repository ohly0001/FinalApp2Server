package ktor.cst8410

@kotlinx.serialization.Serializable
data class HistoryEntry(
    val id: String,
    val payload: Map<String, String> // or whatever shape you want
)

@kotlinx.serialization.Serializable
data class NewHistoryRequest(
    val payload: Map<String, String>
)

@kotlinx.serialization.Serializable
data class IdResponse(
    val id: String
)

@kotlinx.serialization.Serializable
data class StatusResponse(
    val status: String
)