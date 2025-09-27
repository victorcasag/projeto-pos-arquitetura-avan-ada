package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    @DisplayName("Project: defaults and flags")
    void projectDefaults() {
        Project p = new Project();
        p.setName("Proj X");
        p.prePersist();
        assertNotNull(p.getCreatedAt());
        assertFalse(p.getBillableFl());
    }

    @Test
    @DisplayName("Project: getters, setters and lifecycle coverage")
    void projectGettersSettersAndLifecycle() throws InterruptedException {
        Project p = new Project();

        // ids and relations
        p.setId(123);
        p.setDepartmentsId(10);
        p.setProjectTypesId(11);
        p.setSectorsId(12);
        p.setAreasId(13);
        p.setProjectStatusesId(14);
        p.setOriginProjectsId(15);
        p.setCountriesId(16);
        p.setClientsSuppliersId(17);
        p.setLastProjectStatusesId(18);
        p.setCoinTypeId(19);
        p.setOriginProposalId(20);

        p.setName("Project A");
        p.setDescription("Desc");
        p.setProjectDir("/tmp/proj");
        p.setSite("example.com");
        p.setOpeningEmail("open@example.com");
        p.setClassification("ClassA");

        p.setBillableFl(null);
        p.setInternationalFl(null);
        p.setIsDefault(null);
        p.setInvestimentFl(null);
        p.setProductFl(null);

        p.setExchangeRate(new java.math.BigDecimal("2.3456"));

        assertEquals(123, p.getId());
        assertEquals(10, p.getDepartmentsId());
        assertEquals(11, p.getProjectTypesId());
        assertEquals(12, p.getSectorsId());
        assertEquals(13, p.getAreasId());
        assertEquals(14, p.getProjectStatusesId());
        assertEquals(15, p.getOriginProjectsId());
        assertEquals(16, p.getCountriesId());
        assertEquals(17, p.getClientsSuppliersId());
        assertEquals(18, p.getLastProjectStatusesId());
        assertEquals(19, p.getCoinTypeId());
        assertEquals(20, p.getOriginProposalId());

        assertEquals("Project A", p.getName());
        assertEquals("Desc", p.getDescription());
        assertEquals("/tmp/proj", p.getProjectDir());
        assertEquals("example.com", p.getSite());
        assertEquals("open@example.com", p.getOpeningEmail());
        assertEquals("ClassA", p.getClassification());

        assertEquals(0, p.getExchangeRate().compareTo(new java.math.BigDecimal("2.3456")));

        p.setCreatedAt(null);
        p.setUpdatedAt(null);
        p.prePersist();
        assertNotNull(p.getCreatedAt());
        assertNotNull(p.getUpdatedAt());
        assertFalse(p.getBillableFl());
        assertFalse(p.getInternationalFl());
        assertFalse(p.getIsDefault());
        assertFalse(p.getInvestimentFl());
        assertFalse(p.getProductFl());

        java.time.LocalDateTime before = p.getUpdatedAt();
        Thread.sleep(2);
        p.preUpdate();
        assertNotNull(p.getUpdatedAt());
        assertTrue(!p.getUpdatedAt().isBefore(before));

        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        p.setCreatedAt(now);
        p.setUpdatedAt(now);
        assertEquals(now, p.getCreatedAt());
        assertEquals(now, p.getUpdatedAt());
    }
}
