package com.apozdniakov.privateexchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/api")
public class ApiController {

    private final SecretService secretService;

    public ApiController(SecretService secretService) {
        this.secretService = secretService;
    }

    @PostMapping("/create")
    public String createSecret(@RequestBody Secret secret) {
        return secretService.createSecret(secret);
    }

    @GetMapping("/{id}")
    public String getSecret(@PathVariable String id) {
        return secretService.getSecret(id);
    }
}
