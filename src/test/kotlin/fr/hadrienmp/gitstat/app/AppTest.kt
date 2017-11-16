package fr.hadrienmp.gitstat.app

import com.jcabi.http.Request
import com.jcabi.http.request.JdkRequest
import fr.hadrienmp.gitstat.lib.web.PortStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class AppTest {
    companion object {
        private val portStore = PortStore()
    }
    private val port = portStore.get()
    private val app = webapp(port)
    private val serverUrl = "http://localhost:${port.value()}"

    @Test
    fun `should display the random sensei stats`() {
        val response = JdkRequest(serverUrl)
                .method(Request.GET)
                .fetch()
                .body()

        assertThat(response).contains("<h1>Random Sensei</h1>")
    }

    @Before
    fun setUp() {
        app.start()
    }

    @After
    fun stop() {
        app.stop()
        portStore.free(port)
    }
}