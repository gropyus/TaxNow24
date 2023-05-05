package io.taxnow24.backend;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StateControllerTest {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    int port;

    @Test
    void shouldReturnSupportedStates() {
        ResponseEntity<StatesResponse> response = restTemplateBuilder.build()
                .getForEntity("http://localhost:" + port + "/states", StatesResponse.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getStates()).contains("TX");
    }

    @Test
    void shouldAcceptTaxRatePerState(){
        ResponseEntity<String> response = restTemplateBuilder.build().postForEntity("http://localhost:" + port + "/states/UT/tax", 0.0685, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
