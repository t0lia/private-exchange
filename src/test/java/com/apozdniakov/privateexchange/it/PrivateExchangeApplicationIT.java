package com.apozdniakov.privateexchange.it;

import com.apozdniakov.privateexchange.Secret;
import com.apozdniakov.privateexchange.SecretKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class PrivateExchangeApplicationIT extends BaseIT {
    @Test
    @DisplayName("health check response code -> is 200(OK)")
    void checkHealth() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/actuator/health", String.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals("{\"status\":\"UP\"}", response.getBody());
    }

    @Test
    void contextLoads() {
        ResponseEntity<SecretKey> postResponse = testRestTemplate.postForEntity("/api/create", new Secret("test"), SecretKey.class);
        String key = postResponse.getBody().getKey();
        ResponseEntity<Secret> getResponse = testRestTemplate.getForEntity("/api/" + key, Secret.class);
        Assertions.assertEquals(200, getResponse.getStatusCodeValue());
        Assertions.assertEquals("test", getResponse.getBody().getSecret());
    }

}
