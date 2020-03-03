/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.utils;

import com.intel.dcsg.cpg.tls.policy.TlsConnection;
import com.intel.mtwilson.jaxrs2.UserCredential;
import com.intel.mtwilson.jaxrs2.client.AASClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intel.mtwilson.shiro.authc.model.JwtBody;
import java.util.Date;
import org.apache.shiro.codec.Base64;
import java.util.Properties;

/**
 * @author rawatar
 */
public class AASTokenFetcher {
    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AASTokenFetcher.class);

    public String getAASToken(String username, String password, TlsConnection tlsConnection) throws Exception {
        Properties clientConfiguration = new Properties();
        AASClient aasClient = new AASClient(clientConfiguration, tlsConnection);
        UserCredential credential = new UserCredential();
        credential.setUsername(username);
        credential.setPassword(password);
        return aasClient.getToken(credential);
    }
     
    public String updateCachedToken(String userName, String password, TlsConnection tlsConnection, String aasToken) {
        try {
            if (aasToken == null || aasToken.isEmpty()) {
                log.debug("Token not cached, fetching new token from AAS");
                aasToken = getAASToken(userName, password, tlsConnection);
            }
            // check if token is not expired
            ObjectMapper mapper = new ObjectMapper();
            String[] splitToken = aasToken.split("\\.");
            JwtBody jwtBody = mapper.readValue(new String( Base64.decode(splitToken[1])).replaceAll("\0+", "\"}").
                replaceAll("\"{2,}", "\"").getBytes(), JwtBody.class);
            Date currentDate = new Date(System.currentTimeMillis());
            Date tokenExpDate = new Date(Long.parseLong(jwtBody.getExp()) * 1000);
            if (currentDate.after(tokenExpDate)) {
                log.debug("Current time is {}, token expired at {} fetching new token from AAS",currentDate, tokenExpDate);
                aasToken = getAASToken(userName, password, tlsConnection);
            }
            return aasToken;
        } catch(Exception ex) {
             log.error("Error getting AAS token : {}", ex.getMessage());
        }
        return null;
    }
}
