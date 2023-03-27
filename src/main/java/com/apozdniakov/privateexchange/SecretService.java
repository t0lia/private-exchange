package com.apozdniakov.privateexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SecretService {

    Logger logger = LoggerFactory.getLogger(SecretService.class);

    private final Map<UUID, Secret> store = new ConcurrentHashMap<>();

    public String getSecret(String id) {
        logger.info("retrieving secret by id={}", id);
        UUID uuid = UUID.fromString(id);
        return store.get(uuid).value();
    }

    public String createSecret(Secret secret) {
        UUID uuid = UUID.randomUUID();
        store.put(uuid, secret);
        logger.info("secret created, id={}", uuid);
        return uuid.toString();
    }
}
