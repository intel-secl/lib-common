/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.trustagent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import java.util.List;

/**
 * Sample input:   { "nonce":"base64string", "pcrs": [0,1,2,3,18,19,22] }
 * @author jbuhacoff
 */
@JacksonXmlRootElement(localName="tpm_quote_request")
public class TpmQuoteRequest {
    private byte[] nonce; // must be 20 bytes
    private int[] pcrs; // variable-length array of pcr index numbers, each one 0-23 
    private List<String> pcrbanks = new ArrayList(); //the selected PCR banks (SHA1, SHA256, or both) for TPM 2.0

    public List<String> getPcrbanks() {
        return pcrbanks;
    }

    public void setPcrbanks(List<String> pcrBanks) {
        this.pcrbanks.addAll(pcrBanks);
    }
    
    public TpmQuoteRequest() {
        this.nonce = null;
        this.pcrs = null;
    }
    
    public TpmQuoteRequest(byte[] nonce, int[] pcrs) {
        this.nonce = nonce;
        this.pcrs = pcrs;
    }

    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }

    public void setPcrs(int[] pcrs) {
        this.pcrs = pcrs;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public int[] getPcrs() {
        return pcrs;
    }
    
}
