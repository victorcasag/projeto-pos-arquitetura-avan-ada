package com.infnet.victorapiparttwo.integration.apyhub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class APyHubServiceTest {

    @Test
    void convert_returnsDataValue() {
        APyHubClient mockClient = Mockito.mock(APyHubClient.class);
        APyHubResponse resp = new APyHubResponse();
        resp.setData(0.43);
    Mockito.when(mockClient.convert(Mockito.anyString(), Mockito.any(APyHubRequestWithDate.class))).thenReturn(resp);

    APyHubService svc = new APyHubService(mockClient, "dummy-key");
    BigDecimal result = svc.convert("usd", "brl", "2025-09-26");

        assertNotNull(result);
        assertEquals(0, result.compareTo(new BigDecimal("0.43")));
    }
}
