/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.intel.mtwilson.core.common.utils;

import com.intel.dcsg.cpg.io.pem.Pem;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

import javax.security.auth.x500.X500Principal;
import java.io.IOException;
import java.security.*;


public class CertificateUtils {

    public static Pem getCSR(KeyPair signingKey, String commonName) throws OperatorCreationException, IOException {
        PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(new X500Principal(commonName), signingKey.getPublic());
        ContentSigner signGen = new JcaContentSignerBuilder("SHA384withRSA").build(signingKey.getPrivate());
        PKCS10CertificationRequest certificateRequest = csrBuilder.build(signGen);
        return new Pem("CERTIFICATE REQUEST", certificateRequest.getEncoded());
    }

}