package com.apozdniakov.privateexchange;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SecretService {

    private Map<UUID, Secret> store = new ConcurrentHashMap<>();

    public String getSecret(String id) {
        UUID uuid = UUID.fromString(id);
        return store.get(uuid).getValue();
    }

    public String createSecret(Secret secret) {
        UUID uuid = UUID.randomUUID();
        store.put(uuid, secret);
        return uuid.toString();
    }
}
