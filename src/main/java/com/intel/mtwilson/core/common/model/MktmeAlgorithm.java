package com.intel.mtwilson.core.common.model;

/**
 * The MktmeAlgorihtm enum represents a list of all the encryption algorithms
 * that are supported by MKTME.
 * As of now, only AES-XTS-128 is supported.
 *
 * @author rawatar
 */
public enum MktmeAlgorithm {
    AES_XTS_128("AES-XTS-128");

    private String value;

    MktmeAlgorithm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
