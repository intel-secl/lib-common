/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intel.dcsg.cpg.crypto.DigestAlgorithm;
import com.intel.dcsg.cpg.crypto.Sha256Digest;
/**
 *
 * @author dczech
 */
public class PcrSha256 extends Pcr<Sha256Digest> {
    private final Sha256Digest pcrValue;    
    
    public PcrSha256(PcrIndex pcrNumber, byte[] value) {
        super(pcrNumber);
        pcrValue = new Sha256Digest(value);     
    }
    
    public PcrSha256(int pcrNumber, String value) {
        super(PcrIndex.valueOf(pcrNumber));
        pcrValue = new Sha256Digest(value);
    }
    
    @JsonCreator
    public PcrSha256(@JsonProperty("index") String pcrNumber, @JsonProperty("value") String value) {
        super(PcrIndex.valueOf(pcrNumber));
        pcrValue = new Sha256Digest(value);
    }
    
    public PcrSha256(PcrIndex pcrNumber, String value) {
        super(pcrNumber);
        pcrValue = new Sha256Digest(value);   
    }
    
    @Override
    public Sha256Digest getValue() {
        return pcrValue;
    }

    @Override
    public DigestAlgorithm getPcrBank() {
        return DigestAlgorithm.SHA256;
    }

    @Override
    protected void validateOverride() {
        if(!Sha256Digest.isValid(pcrValue.toByteArray())) {
            fault("Invalid SHA256 PCR Value");
        }
    }    
}
