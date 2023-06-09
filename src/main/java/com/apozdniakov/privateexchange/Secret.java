package com.apozdniakov.privateexchange;

public class Secret {
    public Secret(String secret) {
        this.secret = secret;
    }

    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
