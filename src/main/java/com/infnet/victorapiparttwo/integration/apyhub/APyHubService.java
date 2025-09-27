package com.infnet.victorapiparttwo.integration.apyhub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class APyHubService {

    private final APyHubClient client;
    private final String apiKey;

    public APyHubService(APyHubClient client, @Value("${API_KEY}") String apiKey) {
        this.client = client;
        this.apiKey = apiKey;
    }

    public BigDecimal convert(String sourceCurrency, String targetCurrency) {
        APyHubRequest req = new APyHubRequest();
        req.setSource(sourceCurrency);
        req.setTarget(targetCurrency);

        APyHubResponse resp = client.convert(apiKey, req);
        if (resp == null || resp.getData() == null) return null;
        return BigDecimal.valueOf(resp.getData());
    }
}
