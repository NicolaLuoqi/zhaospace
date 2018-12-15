package com.shiliu.zhaospace.controller;

import com.shiliu.zhaospace.api.client.HolleClient;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HolleController implements HolleClient {

    @Override
    public String sayHello() {
        return "hello world!";
    }
}
