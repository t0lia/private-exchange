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
        if (store.containsKey(uuid)) {
            return store.get(uuid).getSecret();
        } else {
            logger.warn("illegal access by the id {}", uuid);
            throw new IllegalArgumentException("no such secret");
        }
    }

    public String createSecret(Secret secret) {
        UUID uuid = UUID.randomUUID();
        store.put(uuid, secret);
        logger.info("secret created, id={}", uuid);
        return uuid.toString();
    }
}
