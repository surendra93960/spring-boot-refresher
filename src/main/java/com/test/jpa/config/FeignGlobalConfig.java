package com.test.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class FeignGlobalConfig {

    public interface invoiceInterface{

        @GetMapping
        public void getPinged();

    }
}
