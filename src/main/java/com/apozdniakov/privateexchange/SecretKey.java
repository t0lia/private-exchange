package com.apozdniakov.privateexchange;

public class SecretKey {

    public SecretKey() {
    }

    public SecretKey(String key) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
