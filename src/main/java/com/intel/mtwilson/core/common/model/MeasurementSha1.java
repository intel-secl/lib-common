/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import com.intel.dcsg.cpg.crypto.Sha1Digest;

/**
 *
 * @author dczech
 */
public class MeasurementSha1 extends Measurement<Sha1Digest> {
    
    public MeasurementSha1(Sha1Digest digest, String label) {
        super(digest, label);
    }
    
    /**
     *
     * @param digest
     * @param label
     * @param info
     */
    @JsonCreator
    public MeasurementSha1(@JsonProperty("value") Sha1Digest digest, @JsonProperty("label") String label, @JsonProperty("info") Map<String,String> info) {
        super(digest, label, info);        
    }
    
    @Override
    protected void validateOverride() {
        if(!Sha1Digest.isValid(this.digest.toByteArray())) {
            fault("SHA1 Digest is invalid");
        }
    }
    
}
