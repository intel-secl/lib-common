/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

/**
 *
 * @author zaaquino
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "host_info", propOrder = {
    "timeStamp",
    "clientIp",
    "errorCode",
    "errorMessage",
    "osName",
    "osVersion",
    "biosOem",
    "biosVersion",
    "vmmName",
    "vmmVersion",
    "processorInfo",
    "hostUUID"
})

@JacksonXmlRootElement(localName = "host_info")
public class HostInfo {
    @XmlElement(name = "timeStamp", required = true)
    protected String timeStamp;
    @XmlElement(name = "clientIp",required = true)
    protected String clientIp;
    @XmlElement(name = "errorCode",required = true)
    protected byte errorCode;
    @XmlElement(name = "errorMessage",required = true)
    protected String errorMessage;
    @XmlElement(name = "hostUUID",required = true)
    protected String hostUUID;

    private String hostName;
    private String biosName;
    private String biosVersion;
    private String hardwareUuid;
    private String osName;
    private String osVersion;
    private String processorInfo;
    private String vmmName;
    private String vmmVersion;
    private String processorFlags;
    private String tpmVersion;
    private List<String> pcrBanks;
    private String noOfSockets;
    private String TpmEnabled;
    private String TxtEnabled;

    public String getNoOfSockets() {
        return noOfSockets;
    }

    public void setNoOfSockets(String noOfSockets) {
        this.noOfSockets = noOfSockets;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
	
	 public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    
/**
     * Gets the value of the clientIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * Sets the value of the clientIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIp(String value) {
        this.clientIp = value;
    }
    public String getBiosName() {
        return biosName;
    }

    public void setBiosName(String biosName) {
        this.biosName = biosName;
    }

    public String getBiosVersion() {
        return biosVersion;
    }

 /**
     * Gets the value of the errorCode property.
     * 
     */
    public byte getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     */
    public void setErrorCode(byte value) {
        this.errorCode = value;
    }
	
    public void setBiosVersion(String biosVersion) {
        this.biosVersion = biosVersion;
    }

    public String getHardwareUuid() {
        return hardwareUuid;
    }

     public String getErrorMessage() {
        return errorMessage;
	 }
	 public void setErrorMessage(String value) {
	      this.errorMessage = value;
     }
    
	public void setHardwareUuid(String hardwareUuid) {
        this.hardwareUuid = hardwareUuid;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getProcessorInfo() {
        return processorInfo;
    }

    public void setProcessorInfo(String processorInfo) {
        this.processorInfo = processorInfo;
    }

    public String getVmmName() {
        return vmmName;
    }

    public void setVmmName(String vmmName) {
        this.vmmName = vmmName;
    }

    public String getVmmVersion() {
        return vmmVersion;
    }

    public void setVmmVersion(String vmmVersion) {
        this.vmmVersion = vmmVersion;
    }

    public String getProcessorFlags() {
        return processorFlags;
    }

    public void setProcessorFlags(String processorFlags) {
        this.processorFlags = processorFlags;
    }

    public String getTpmVersion() {
        return tpmVersion;
    }

    public void setTpmVersion(String tpmVersion) {
        this.tpmVersion = tpmVersion;
    }

    public List<String> getPcrBanks() {
        return pcrBanks;
    }

    public void setPcrBanks(List<String> pcrBanks) {
        this.pcrBanks = pcrBanks;
    }

    public String getTpmEnabled() {
        return TpmEnabled;
    }

    public void setTpmEnabled(String TpmEnabled) {
        this.TpmEnabled = TpmEnabled;
    }

    public String getTxtEnabled() {
        return TxtEnabled;
    }

    public void setTxtEnabled(String TxtEnabled) {
        this.TxtEnabled = TxtEnabled;
    }    
}
