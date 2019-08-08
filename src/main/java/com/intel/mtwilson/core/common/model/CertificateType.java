package com.intel.mtwilson.core.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ddhawale
 */
public enum CertificateType {
    TLS("TLS"),
    FLAVOR_SIGNING("Flavor-Signing"),
    JWT_SIGNING("JWT-Signing");

    private String value;

    CertificateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

