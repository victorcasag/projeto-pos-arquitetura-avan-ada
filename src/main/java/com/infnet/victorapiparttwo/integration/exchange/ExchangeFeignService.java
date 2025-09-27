package com.infnet.victorapiparttwo.integration.exchange;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ExchangeFeignService {

    private final ExchangeFeignClient client;

    public ExchangeFeignService(ExchangeFeignClient client) {
        this.client = client;
    }

    public BigDecimal getExchangeRate(String base, String symbol) {
        ExchangeResponse resp = client.latest(base, symbol);
        if (resp == null || resp.getRates() == null) return BigDecimal.ONE;
        Map<String, Double> rates = resp.getRates();
        Double v = rates.get(symbol);
        if (v == null) return BigDecimal.ONE;
        return BigDecimal.valueOf(v);
    }
}
