package io.taxnow24.backend

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class StateControllerTest {
    @Autowired
    var restTemplateBuilder: RestTemplateBuilder? = null

    @LocalServerPort
    var port = 0

    @Test
    fun `should return supported states`() {
        val response = restTemplateBuilder!!.build()
            .getForEntity("http://localhost:$port/states", List::class.java)
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(response.body).contains("TX")
    }

    @Test
    fun `should accept tax rate per state`() {
        val response = restTemplateBuilder!!.build()
            .postForEntity("http://localhost:$port/states/UT/tax", 0.0685, String::class.java)

        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }
}
