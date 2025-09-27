package com.infnet.victorapiparttwo.service;

import com.infnet.victorapiparttwo.model.domain.Project;

import java.math.BigDecimal;

public class ProjectService {

    /**
     * Ensure nullable booleans and exchangeRate have sensible defaults.
     */
    public void ensureDefaults(Project project) {
        if (project == null) return;
        if (project.getBillableFl() == null) project.setBillableFl(false);
        if (project.getInternationalFl() == null) project.setInternationalFl(false);
        if (project.getIsDefault() == null) project.setIsDefault(false);
        if (project.getInvestimentFl() == null) project.setInvestimentFl(false);
        if (project.getProductFl() == null) project.setProductFl(false);
        if (project.getExchangeRate() == null) project.setExchangeRate(BigDecimal.ONE);
    }

    /**
     * Validate required fields. Throws IllegalArgumentException when invalid.
     */
    public void validateRequiredFields(Project project) {
        if (project == null) throw new IllegalArgumentException("project is required");
        if (project.getName() == null || project.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("project.name is required");
        }
    }

    /**
     * Apply project's exchange rate to an amount. If exchangeRate is null, treat as 1.
     */
    public BigDecimal applyExchangeRate(BigDecimal amount, Project project) {
        if (amount == null) return null;
        BigDecimal rate = (project != null && project.getExchangeRate() != null)
                ? project.getExchangeRate()
                : BigDecimal.ONE;
        return amount.multiply(rate);
    }
}
