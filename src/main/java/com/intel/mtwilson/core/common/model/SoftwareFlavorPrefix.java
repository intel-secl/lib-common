/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intel.mtwilson.core.common.model;

/**
 *
 * @author hmgowda
 */
public enum SoftwareFlavorPrefix {
    DEFAULT_APPLICATION_FLAVOR_PREFIX("ISecL_Default_Application_Flavor_v"),
    DEFAULT_WORKLOAD_FLAVOR_PREFIX("ISecL_Default_Workload_Flavor_v");

    private String value;

    SoftwareFlavorPrefix(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
