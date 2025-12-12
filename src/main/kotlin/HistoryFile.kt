package ktor.cst8410

import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import java.io.File

private val historyFile = File("..\\data\\history.jsonl")
val json = Json { ignoreUnknownKeys = true }

fun readHistory(): List<HistoryEntry> {
    if (!historyFile.exists()) return emptyList()

    return historyFile.readLines().mapNotNull { line ->
        try {
            json.decodeFromString<HistoryEntry>(line)
        } catch (_: Exception) {
            null
        }
    }
}

fun appendHistory(entry: HistoryEntry) {
    if (!historyFile.exists()) historyFile.createNewFile()
    historyFile.appendText(json.encodeToString(entry) + "\n")
}

fun writeHistory(entries: List<HistoryEntry>) {
    historyFile.writeText(entries.joinToString("\n") { json.encodeToString(it) })
}