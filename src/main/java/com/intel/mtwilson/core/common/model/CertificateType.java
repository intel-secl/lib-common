package com.intel.mtwilson.core.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ddhawale
 */
public enum CertificateType {
    TLS("TLS"),
    JWT_SIGNING("JWT-Signing"),
    SIGNING("Signing"),
    SIGNING_CA("Signing-CA");

    private String value;

    CertificateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

