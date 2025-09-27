package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProposalStatusTest {

    @Test
    @DisplayName("ProposalStatus: enum-like entity defaults")
    void proposalStatusDefaults() {
        ProposalStatus ps = new ProposalStatus();
        ps.setName("Draft");
        ps.prePersist();
        assertNotNull(ps.getCreatedAt());
        assertEquals("Draft", ps.getName());
    }
}
