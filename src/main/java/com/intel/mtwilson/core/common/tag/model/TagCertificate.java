/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.tag.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.intel.dcsg.cpg.io.UUID;
import com.intel.dcsg.cpg.validation.Regex;
import com.intel.dcsg.cpg.validation.RegexPatterns;
import com.intel.dcsg.cpg.x509.X509CertificateEncodingException;
import com.intel.dcsg.cpg.x509.X509CertificateFormatException;
import com.intel.dcsg.cpg.x509.X509Util;
import com.intel.mtwilson.jaxrs2.CertificateDocument;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author ssbangal
 */
@JacksonXmlRootElement(localName="certificate")
public class TagCertificate extends CertificateDocument{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TagCertificate.class);
    private byte[] certificate;
    private String subject;
    private String issuer;
    private Date notBefore;
    private Date notAfter;
    private UUID hardwareUuid;

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public UUID getHardwareUuid() {
        return hardwareUuid;
    }

    public void setHardwareUuid(UUID hardwareUuid) {
        this.hardwareUuid = hardwareUuid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Regex(RegexPatterns.ANY_VALUE)    
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(Date notBefore) {
        this.notBefore = notBefore;
    }

    public Date getNotAfter() {
        return notAfter;
    }

    public void setNotAfter(Date notAfter) {
        this.notAfter = notAfter;
    }

    // you still need to setUuid() after calling this since it's not included in the serialized form
    @JsonCreator
    public static TagCertificate valueOf(String text) throws UnsupportedEncodingException {
        byte[] data = Base64.decodeBase64(text);
        return valueOf(data);
    }

    // you still need to setUuid() after calling this since it's not included in the serialized form
    public static TagCertificate valueOf(byte[] data) throws UnsupportedEncodingException {
        TagCertificate certificate = new TagCertificate();
        certificate.setCertificate(data);
        X509AttributeCertificate attrcert = X509AttributeCertificate.valueOf(data);
        certificate.setIssuer(attrcert.getIssuer());
        certificate.setSubject(attrcert.getSubject());
        certificate.setNotBefore(attrcert.getNotBefore());
        certificate.setNotAfter(attrcert.getNotAfter());
        log.debug("valueOf ok");
        return certificate;
    }
    
    @JsonIgnore
    @Override
    public X509Certificate getX509Certificate() {
        if( certificate == null ) { return null; }
        try {
            log.debug("Certificate bytes length {}", certificate.length);
            return X509Util.decodeDerCertificate(certificate);
        }
        catch(CertificateException e) {
            throw new X509CertificateFormatException(e, certificate);
        }
    }

    @JsonIgnore
    @Override
    public void setX509Certificate(X509Certificate certificate) {
        if( certificate == null ) {
            this.certificate = null;
            return;
        }
        try {
            this.certificate = certificate.getEncoded();
        }
        catch(CertificateEncodingException e) {
            log.error("Error decoding certificate.", e);
            throw new X509CertificateEncodingException(e, certificate);
        }
    }
    
    
}
