package com.infnet.victorapiparttwo.integration.apyhub;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "apyhubClient", url = "${URL_API_CURRENCY}")
public interface APyHubClient {

    @PostMapping(consumes = "application/json", produces = "application/json")
    APyHubResponse convert(
        @RequestHeader("apy-token") String apiKey,
        @RequestBody APyHubRequestWithDate request
    );
}
