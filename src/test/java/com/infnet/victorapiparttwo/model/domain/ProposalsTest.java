package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Proposals domain tests")
class ProposalsTest {

    @Test
    @DisplayName("prePersist sets timestamps and defaults")
    void prePersistSetsDefaults() {
        Proposals p = new Proposals();
        p.setName("Test");
        p.setExchangeRate(null);
        p.setPriority(null);

        p.prePersist();

        assertNotNull(p.getCreatedAt());
        assertNotNull(p.getUpdatedAt());
        assertEquals(BigDecimal.ONE, p.getExchangeRate());
        assertEquals(0, p.getPriority());
    }

    @Test
    @DisplayName("preUpdate updates updatedAt")
    void preUpdateUpdatesTime() throws InterruptedException {
        Proposals p = new Proposals();
        p.prePersist();
        LocalDateTime before = p.getUpdatedAt();
        Thread.sleep(5);
        p.preUpdate();
        assertNotNull(p.getUpdatedAt());
        assertTrue(!p.getUpdatedAt().isBefore(before));
    }

    @Test
    @DisplayName("getters and setters work")
    void gettersSetters() {
        Proposals p = new Proposals();
        p.setName("Name");
        p.setDescription("Desc");
        p.setValue(new BigDecimal("123.45"));

        assertEquals("Name", p.getName());
        assertEquals("Desc", p.getDescription());
        assertEquals(0, p.getValue().compareTo(new BigDecimal("123.45")));
    }

    @Test
    @DisplayName("Proposals: full getters/setters and lifecycle coverage")
    void proposalsFullCoverage() throws InterruptedException {
        Proposals p = new Proposals();

        p.setId(77);
        p.setDepartmentId(2);
        p.setSectorId(3);
        p.setAreaId(4);
        p.setClientSupplierId(5);
        p.setContractId(6);
        p.setOfficeId(7);
        p.setCoinTypeId(8);
        p.setCountryId(9);
        p.setStatusId(10);
        p.setResponsibleId(11);
        p.setOriginProposalId(12);
        p.setProposalNumber("PN-001");
        p.setProposalSubNumber("PN-001-A");
        p.setSite("site.example");
        p.setValue(new BigDecimal("500.00"));
        p.setSchedule("Q1");
        p.setIbt(new BigDecimal("0.1234"));
        p.setPaymentDays(30);
        p.setEstimatedStart(java.time.LocalDate.of(2025, 10, 1));
        p.setProbability(new BigDecimal("75.5"));
        p.setCompanyName("Acme Co");
        p.setPriority(2);
        p.setDueDays(15);
        p.setExchangeRate(new BigDecimal("1.2345"));

        assertEquals(77, p.getId());
        assertEquals(2, p.getDepartmentId());
        assertEquals(3, p.getSectorId());
        assertEquals(4, p.getAreaId());
        assertEquals(5, p.getClientSupplierId());
        assertEquals(6, p.getContractId());
        assertEquals(7, p.getOfficeId());
        assertEquals(8, p.getCoinTypeId());
        assertEquals(9, p.getCountryId());
        assertEquals(10, p.getStatusId());
        assertEquals(11, p.getResponsibleId());
        assertEquals(12, p.getOriginProposalId());
        assertEquals("PN-001", p.getProposalNumber());
        assertEquals("PN-001-A", p.getProposalSubNumber());
        assertEquals("site.example", p.getSite());
        assertEquals(0, p.getValue().compareTo(new BigDecimal("500.00")));
        assertEquals("Q1", p.getSchedule());
        assertEquals(0, p.getIbt().compareTo(new BigDecimal("0.1234")));
        assertEquals(30, p.getPaymentDays());
        assertEquals(java.time.LocalDate.of(2025, 10, 1), p.getEstimatedStart());
        assertEquals(0, p.getProbability().compareTo(new BigDecimal("75.5")));
        assertEquals("Acme Co", p.getCompanyName());
        assertEquals(2, p.getPriority());
        assertEquals(15, p.getDueDays());
        assertEquals(0, p.getExchangeRate().compareTo(new BigDecimal("1.2345")));

        p.setCreatedAt(null);
        p.setUpdatedAt(null);
        p.setExchangeRate(null);
        p.setPriority(null);
        p.prePersist();
        assertNotNull(p.getCreatedAt());
        assertNotNull(p.getUpdatedAt());
        assertEquals(java.math.BigDecimal.ONE, p.getExchangeRate());
        assertEquals(0, p.getPriority());

        java.time.LocalDateTime before = p.getUpdatedAt();
        Thread.sleep(2);
        p.preUpdate();
        assertNotNull(p.getUpdatedAt());
        assertTrue(!p.getUpdatedAt().isBefore(before));
    }

    @Test
    @DisplayName("defaults and preUpdate flow")
    void proposalsDefaultsAndUpdate() throws InterruptedException {
        Proposals p = new Proposals();
        p.setName("P2");
        p.setExchangeRate(null);
        p.setPriority(null);
        p.prePersist();
        assertNotNull(p.getExchangeRate());
        assertEquals(0, p.getPriority());
    Thread.sleep(1);
        p.preUpdate();
        assertNotNull(p.getUpdatedAt());
    }
}
