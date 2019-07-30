package com.intel.mtwilson.core.common.cms.client.jaxrs;

import com.intel.dcsg.cpg.tls.policy.TlsConnection;
import com.intel.mtwilson.jaxrs2.client.MtWilsonClient;
import com.intel.mtwilson.jaxrs2.mediatype.CryptoMediaType;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import java.security.cert.X509Certificate;
import java.util.Properties;

/**
 *
 * @author arijitgh
 */
public class CMSClient extends MtWilsonClient {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CMSClient.class);

    public CMSClient(Properties properties, TlsConnection tlsConnection) throws Exception {
        super(properties, tlsConnection);
    }

    public X509Certificate getCACertificate() {
        log.info("target: {}", getTarget().getUri().toString());
        X509Certificate cmsCertificate = getTarget()
                .path("/ca-certificates")
                .request()
                .accept(CryptoMediaType.APPLICATION_X_PEM_FILE)
                .get(X509Certificate.class);
        return cmsCertificate;
    }

    public X509Certificate getFlavorSigningCertificate(String flavorSigningCSR) {
        log.info("target: {}", getTarget().getUri().toString());
        flavorSigningCSR.replace("\r\n", "");
        X509Certificate flavorSigningCertificate = getTarget()
                .path("/certificates")
                .queryParam("certType", "Flavor-Signing")
                .request()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + super.getConfiguration().get("bearer.token"))
                .accept(CryptoMediaType.APPLICATION_X_PEM_FILE)
                .post(Entity.entity(flavorSigningCSR, CryptoMediaType.APPLICATION_X_PEM_FILE), X509Certificate.class);
        return flavorSigningCertificate;
    }
}
