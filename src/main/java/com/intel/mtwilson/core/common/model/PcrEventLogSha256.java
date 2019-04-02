/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intel.dcsg.cpg.crypto.DigestAlgorithm;
import java.util.List;
/**
 *
 * @author dczech
 */
public class PcrEventLogSha256 extends PcrEventLog<MeasurementSha256> {
    
    public PcrEventLogSha256(PcrIndex pcrIndex) {
        super(pcrIndex);
    }
    
    @JsonCreator
    public PcrEventLogSha256(@JsonProperty("pcr_index") PcrIndex pcrIndex, @JsonProperty("event_log") List<MeasurementSha256> moduleManifest) {
        super(pcrIndex, moduleManifest);        
    }
    
    @Override
    public DigestAlgorithm getPcrBank() {
        return DigestAlgorithm.SHA256;
    }
}
