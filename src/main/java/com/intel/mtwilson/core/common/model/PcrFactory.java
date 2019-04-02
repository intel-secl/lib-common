/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.intel.dcsg.cpg.crypto.DigestAlgorithm;

/**
 *
 * @author dczech
 */
public class PcrFactory {
    public static Pcr newInstance(DigestAlgorithm algorithm, PcrIndex index, String value) {
        switch(algorithm) {
            case SHA1:
                return new PcrSha1(index, value);
            case SHA256:
                return new PcrSha256(index, value);
            default:
                throw new UnsupportedOperationException("algorithm: " + algorithm + " not implemented yet");
        }
    }
    
    public static Pcr newInstance(String algorithm, PcrIndex index, String value) {
        return newInstance(DigestAlgorithm.valueOf(algorithm), index, value);
    }
    
    public static Pcr newInstance(DigestAlgorithm algorithm, PcrIndex index, byte[] value) {
        switch (algorithm) {
            case SHA1:
                return new PcrSha1(index, value);
            case SHA256:
                return new PcrSha256(index, value);
            default:
                throw new UnsupportedOperationException("algorithm: " + algorithm + " not implemented yet");
        }
    }
    
    public static Pcr newInstance(String algorithm, PcrIndex index, byte[] value) {
        return PcrFactory.newInstance(DigestAlgorithm.valueOf(algorithm), index, value);
    }
}
