package ktor.cst8410

import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respondText
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        post("/add") {
            val query = call.receive<ArithmeticRequest>()
            call.respondText((query.a + query.b).toString())
        }
        post("/subtract") {
            val query = call.receive<ArithmeticRequest>()
            call.respondText((query.a - query.b).toString())
        }
        post("/multiply") {
            val query = call.receive<ArithmeticRequest>()
            call.respondText((query.a * query.b).toString())
        }
        post("/divide") {
            val query = call.receive<ArithmeticRequest>()
            call.respondText((query.a / query.b).toString())
        }
    }
}
