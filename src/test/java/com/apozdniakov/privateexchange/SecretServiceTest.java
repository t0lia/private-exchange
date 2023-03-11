package com.apozdniakov.privateexchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecretServiceTest {
    @Test
    public void testStoringSecrets() {
        SecretService service = new SecretService();
        String id = service.createSecret(new Secret("test"));
        assertEquals("test", service.getSecret(id));
    }

}