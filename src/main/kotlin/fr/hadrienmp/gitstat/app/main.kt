package fr.hadrienmp.gitstat.app

import fr.hadrienmp.gitstat.lib.web.Port
import fr.hadrienmp.gitstat.lib.web.WebApp


fun main(args: Array<String>) {
    webapp(Port(args)).start()
}

fun webapp(port: Port): WebApp {
    return WebApp(port).routes {
        it.get("/") {
            it.result("""
                <html>
                    <h1>Random Sensei</h1>
                </html>
            """.trimIndent())
        }
    }
}

