/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.intel.dcsg.cpg.crypto.AbstractDigest;
import com.intel.dcsg.cpg.crypto.DigestAlgorithm;
import com.intel.dcsg.cpg.validation.ObjectModel;
import java.util.Objects;

/**
 * BUG #497   renamed to "Pcr" to represent a pair (index,value)
 * the value can continue to be represented as Sha1Digest. 
 * Representation of a single PCR Value in the TPM. A PCR value consists of
 * the PCR Number and the SHA1 Digest. 
 * 
 * @param <T>
 * @since 0.5.4
 * @author jbuhacoff
 */

@JsonTypeInfo(use = Id.CLASS,
              include = JsonTypeInfo.As.PROPERTY,
              property = "digest_type")
@JsonSubTypes({
    @Type(value = PcrSha1.class),
    @Type(value = PcrSha256.class)
})
public abstract class Pcr<T extends AbstractDigest> extends ObjectModel {
    private final PcrIndex pcrIndex;          
    
    protected Pcr(PcrIndex pcrNumber) {
        pcrIndex = pcrNumber;
    }
    
    public PcrIndex getIndex() { return pcrIndex; } // BUG #497 needs to be renamed getIndex() and return a type PcrIndex
    abstract public T getValue();
    abstract public DigestAlgorithm getPcrBank();
    /**
     * Returns a string representing the PCR Value in the format "pcr: value"
     * Example: assert new PcrValue(15,"...").toString().equals("15: ...");
     *
     * @return 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s: %d: %s", getPcrBank(), pcrIndex.toInteger(), getValue().toString());
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Pcr)) {
            return false;
        }
        Pcr pcr = (Pcr) o;
        return Objects.equals(pcrIndex, pcr.pcrIndex)
                && Objects.equals(getPcrBank(), pcr.getPcrBank())
                && Objects.equals(getValue(), pcr.getValue())
                && Objects.equals(getFaults(), pcr.getFaults());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(pcrIndex, getPcrBank(), getValue(), getFaults());
    }
    
    @Override
    public void validate() {
        if( pcrIndex == null ) { fault("Pcr index is null"); }
        else if( !pcrIndex.isValid() ) { fault(pcrIndex, "Invalid pcr index"); }
        if( getValue() == null ) { fault("Digest is null"); }

        validateOverride();                
    }
    
    protected abstract void validateOverride();

}
