package com.apozdniakov.privateexchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final SecretService secretService;

    public MainController(SecretService secretService) {
        this.secretService = secretService;
    }

    @GetMapping("/")
    public String index() {
        return "Private Exchange application";
    }

    @GetMapping("/{id}")
    public String getSecret(@PathVariable String id) {
        return secretService.getSecret(id);
    }

    @PostMapping("/")
    public String createSecret(@RequestBody Secret secret) {
        return secretService.createSecret(secret);
    }
}
