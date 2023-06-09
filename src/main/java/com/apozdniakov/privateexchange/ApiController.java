package com.apozdniakov.privateexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/api")
public class ApiController {

    public static Logger logger = LoggerFactory.getLogger(MainController.class);

    private final SecretService secretService;

    public ApiController(SecretService secretService) {
        this.secretService = secretService;
    }

    @PostMapping("/create")
    public ResponseEntity<SecretKey> createSecret(@RequestBody Secret secret) {
        logger.info("Create secret endpoint was called");
        return ResponseEntity.ok(new SecretKey(secretService.createSecret(secret)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secret> getSecret(@PathVariable String id) {
        logger.info("Get secret endpoint was called");
        Secret secret = new Secret(secretService.getSecret(id));
        return ResponseEntity.ok(secret);
    }
}
