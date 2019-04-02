/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.intel.dcsg.cpg.crypto.DigestAlgorithm;
import java.util.List;

/**
 *
 * @author dczech
 */
public class PcrEventLogFactory {
    protected PcrEventLogFactory() {
        
    }
    
    public static PcrEventLog newInstance(DigestAlgorithm bank, PcrIndex index, List modules) {
        switch(bank) {
            case SHA1:
                return new PcrEventLogSha1(index, modules);
            case SHA256:
                return new PcrEventLogSha256(index, modules);
            default:
                throw new UnsupportedOperationException("PCRBank: " + bank + " not currently supported");
        }
    }
    
    public static PcrEventLog newInstance(String bank, PcrIndex index, List modules) {
        return newInstance(DigestAlgorithm.valueOf(bank), index, modules);
    }
}
