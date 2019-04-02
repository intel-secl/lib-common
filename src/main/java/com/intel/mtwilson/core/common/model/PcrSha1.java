/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intel.dcsg.cpg.crypto.DigestAlgorithm;
import com.intel.dcsg.cpg.crypto.Sha1Digest;

/**
 *
 * @author dczech
 */
public class PcrSha1 extends Pcr<Sha1Digest> {

    private final Sha1Digest pcrValue;
    
    public PcrSha1(PcrIndex pcrNumber, byte[] value) {
        super(pcrNumber);
        pcrValue = new Sha1Digest(value);
    }
    
    public PcrSha1(int pcrNumber, String value) {
        super(PcrIndex.valueOf(pcrNumber));
        pcrValue = new Sha1Digest(value);
    }
    
    @JsonCreator
    public PcrSha1(@JsonProperty("index") String pcrNumber, @JsonProperty("value") String value) {
        super(PcrIndex.valueOf(pcrNumber));
        pcrValue = new Sha1Digest(value);
    }
    
    public PcrSha1(PcrIndex pcrNumber, String value) {
        super(pcrNumber);
        pcrValue = new Sha1Digest(value);
    }

    @Override
    public Sha1Digest getValue() {
        return pcrValue;
    }

    @Override
    public DigestAlgorithm getPcrBank() {
        return DigestAlgorithm.SHA1;
    }
    
    @Override
    protected void validateOverride() {
        if(!Sha1Digest.isValid(pcrValue.toByteArray())) {
            fault("Invalid SHA1 PCR Value");
        }
    }
    
}
