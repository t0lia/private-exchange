package com.apozdniakov.privateexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    public static Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String index() {

        logger.info("Main controller was called");
        return "Private Exchange application v1.1";
    }
}
