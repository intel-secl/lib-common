/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.intel.mtwilson.core.common.tag.model.X509AttributeCertificate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intel.mtwilson.jackson.X509CertificateDeserializer;
import com.intel.mtwilson.jackson.X509CertificateSerializer;
import com.intel.mtwilson.core.common.tag.model.json.X509AttributeCertificateDeserializer;
import java.security.cert.X509Certificate;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * HostManifest is the new model class intended to be used/shared among core
 * libraries.
 *
 * @author zaaquino
 */
public class HostManifest {
    @JsonSerialize(using=X509CertificateSerializer.class)
    @JsonDeserialize(using=X509CertificateDeserializer.class)
    private X509Certificate aikCertificate;
    
    private byte[] assetTagDigest;
    private HostInfo hostInfo;
    private PcrManifest pcrManifest;
    
    //@JsonSerialize(using=X509AttributeCertificateSerializer.class)
    @JsonDeserialize(using=X509AttributeCertificateDeserializer.class)
    private X509AttributeCertificate tagCertificate;

    public X509Certificate getAikCertificate() {
        return aikCertificate;
    }

    public void setAikCertificate(X509Certificate value) {
        aikCertificate = value;
    }

    public byte[] getAssetTagDigest() {
        return assetTagDigest;
    }

    public void setAssetTagDigest(byte[] value) {
        assetTagDigest = value;
    }

    public HostInfo getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(HostInfo value) {
        hostInfo = value;
    }

    public PcrManifest getPcrManifest() {
        return pcrManifest;
    }

    public void setPcrManifest(PcrManifest value) {
        pcrManifest = value;
    }

    public X509AttributeCertificate getTagCertificate() {
        return tagCertificate;
    }

    public void setTagCertificate(X509AttributeCertificate value) {
        tagCertificate = value;
    }

}
