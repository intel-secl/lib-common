package com.intel.mtwilson.core.common.model;

/**
 * The AttestationExemptFeature enum represents a list of all the hardware features
 * that do not play any role in attestation process.
 * As of now, SUEFI is also included in this list because we do not have attestation information.
 *
 * @author rawatar
 */
public enum AttestationExemptFeature {
    MKTME;
}
