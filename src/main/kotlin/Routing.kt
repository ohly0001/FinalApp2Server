package ktor.cst8410

import org.json.JSONObject
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.io.File
import java.util.UUID

fun Application.configureRouting() {
    routing {

        // ------------------------
        // Home page
        // ------------------------
        get("/") {
            call.respondText(
                File("..\\resources\\info\\permissions.html")
                    .readText(Charsets.UTF_8),
                ContentType.Text.Html
            )
        }

        // ------------------------
        // GET /history/all/
        // ------------------------
        get("/history/all/") {
            val all = readHistory()
            call.respondText(
                json.encodeToString(all),
                ContentType.Application.Json
            )
        }

        // ------------------------
        // POST /history
        // Adds new item
        // ------------------------
        post("/history") {
            val req = call.receive<NewHistoryRequest>()
            val id = UUID.randomUUID().toString()

            val entry = HistoryEntry(id = id, payload = req.payload)
            appendHistory(entry)

            call.respond(IdResponse(id))
        }

        // ------------------------
        // DELETE /history/{id}
        // ------------------------
        delete("/history/{id}") {
            val id = call.parameters["id"]
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Missing id")
                return@delete
            }

            val old = readHistory()
            val new = old.filterNot { it.id == id }

            writeHistory(new)
            call.respond(StatusResponse("deleted"))
        }

        // ------------------------
        // DELETE /history/all
        // ------------------------
        delete("/history/all") {
            writeHistory(emptyList())
            call.respond(StatusResponse("cleared"))
        }
    }
}
