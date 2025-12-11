package ktor.cst8410

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respondText
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.io.File
import java.util.UUID
import org.json.JSONObject

fun Application.configureRouting() {
    routing {
        // Default -
        get("/") {
            //val query = call.receive<ArithmeticRequest>()
            call.respondText(
                File("..\\resources\\info\\permissions.html").readText(Charsets.UTF_8),
                ContentType.Text.Html,
                status = HttpStatusCode.OK
            )
        }
        get("/history/all/") {
            val uuid = call.receive<UUID>()
        }
        post("/history") {
            val uuid = call.receive<JSONObject>()
        }
        delete("/history/:id") {
            //val query = call.receive<ArithmeticRequest>()
            //call.respond(query.a - query.b)
        }
        delete("/history/all") {
            //val query = call.receive<ArithmeticRequest>()
            //call.respond(query.a - query.b)
        }
    }
}
