package com.intel.mtwilson.core.common.model;

import java.util.Map;
/**
 *
 * @author ddhawal
 */
public class HardwareFeatureDetails {
    private boolean enabled;
    private Map<String, String> meta;

    public HardwareFeatureDetails() {
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }
}
