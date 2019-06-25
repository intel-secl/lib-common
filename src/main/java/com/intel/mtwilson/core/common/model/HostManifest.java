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
import java.util.ArrayList;
import java.util.List;

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
    
    @JsonDeserialize(using=X509AttributeCertificateDeserializer.class)
    private X509AttributeCertificate tagCertificate;

    @JsonSerialize(using=X509CertificateSerializer.class)
    @JsonDeserialize(using=X509CertificateDeserializer.class)
    private X509Certificate bindingKeyCertificate;
    
    private boolean tpmEnabled;
    private boolean txtEnabled;
    private List<String> measurementXmls;
    private byte[] ProvisionedTag;

    public HostManifest() {
        this.measurementXmls = new ArrayList<>();
        this.ProvisionedTag = null;
    }

	public byte[] getProvisionedTag() {
        return ProvisionedTag;
    }

    public void setProvisionedTag(byte[] ProvisionedTag) {
        this.ProvisionedTag = ProvisionedTag;
    }	
	
	public List<String> getMeasurementXmls() {
        return measurementXmls;
    }

    public void setMeasurementXmls(List<String> measurementXmls) {
        this.measurementXmls = measurementXmls;
    }


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

    public boolean getTpmEnabled() {
        return tpmEnabled;
    }

    public void setTpmEnabled(boolean value) {
        tpmEnabled = value;
    }

    public boolean getTxtEnabled() {
        return txtEnabled;
    }

    public void setTxtEnabled(boolean value) {
        txtEnabled = value;
    }
    public X509Certificate getBindingKeyCertificate() {
        return bindingKeyCertificate;
    }

    public void setBindingKeyCertificate(X509Certificate bindingKeyCertificate) {
        this.bindingKeyCertificate = bindingKeyCertificate;
    }


}
