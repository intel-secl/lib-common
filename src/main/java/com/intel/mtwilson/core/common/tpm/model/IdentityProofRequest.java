/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.tpm.model;

/**
 *
 * @author dczech
 */
public final class IdentityProofRequest {

    public byte[] getAsymBlob() {
        return asymBlob;
    }

    public void setAsymBlob(byte[] asymBlob) {
        this.asymBlob = asymBlob;
    }

    public byte[] getSymBlob() {
        return symBlob;
    }

    public void setSymBlob(byte[] symBlob) {
        this.symBlob = symBlob;
    }

    public byte[] getEkBlob() {
        return ekBlob;
    }

    public void setEkBlob(byte[] ekBlob) {
        this.ekBlob = ekBlob;
    }
    
    
    byte[] secret;
    byte[] credential;

    public byte[] getSecret() {
        return secret;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }

    public byte[] getCredential() {
        return credential;
    }

    public void setCredential(byte[] credential) {
        this.credential = credential;
    }
    byte[] asymBlob;
    byte[] symBlob;
    byte[] ekBlob;
}
