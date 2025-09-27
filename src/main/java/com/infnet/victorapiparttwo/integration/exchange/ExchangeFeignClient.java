package com.infnet.victorapiparttwo.integration.exchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchange", url = "${exchange.base-url:https://api.exchangerate.host}")
public interface ExchangeFeignClient {

    @GetMapping("/latest")
    ExchangeResponse latest(@RequestParam("base") String base, @RequestParam("symbols") String symbols);
}
