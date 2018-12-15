package com.shiliu.zhaospace.api.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "api/hello")
public interface HolleClient {

    @GetMapping(value = "sayHello")
    String sayHello();
}
