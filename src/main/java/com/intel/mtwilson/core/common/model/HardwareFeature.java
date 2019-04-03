package com.intel.mtwilson.core.common.model;

/**
 *
 * @author ddhawal
 */
public enum HardwareFeature {
    TPM("TPM"),
    TXT("TXT"),
    CBNT("CBNT"),
    SUEFI("SUEFI"),
    MKTME("MKTME");

    private String value;

    HardwareFeature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
