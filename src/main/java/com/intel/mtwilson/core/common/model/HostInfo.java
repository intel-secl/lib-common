/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import java.util.Map;

import java.util.Set;
/**
 *
 * @author zaaquino
 */

@JacksonXmlRootElement(localName = "host_info")
public class HostInfo {
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
    private String tbootInstalled;
    private Map<HardwareFeature, HardwareFeatureDetails> hardwareFeatures;
    private Set<String> installedComponents;

    public String getNoOfSockets() {
        return noOfSockets;
    }

    public void setNoOfSockets(String noOfSockets) {
        this.noOfSockets = noOfSockets;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    public void setBiosVersion(String biosVersion) {
        this.biosVersion = biosVersion;
    }

    public String getHardwareUuid() {
        return hardwareUuid;
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

    public String getTbootInstalled() {
        return tbootInstalled;
    }

    public void setTbootInstalled(String tbootInstalled) {
        this.tbootInstalled = tbootInstalled;
    }

    public Map<HardwareFeature, HardwareFeatureDetails> getHardwareFeatures() {
        return hardwareFeatures;
    }

    public void setHardwareFeatures(Map<HardwareFeature, HardwareFeatureDetails> hardwareFeatures) {
        this.hardwareFeatures = hardwareFeatures;
    }

    public Set<String> getInstalledComponents() {
        return installedComponents;
    }

    public void setInstalledComponents(Set<String> installedComponents) {
        this.installedComponents = installedComponents;
    }
}
