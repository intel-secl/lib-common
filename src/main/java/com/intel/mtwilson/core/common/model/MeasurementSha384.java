package com.intel.mtwilson.core.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intel.dcsg.cpg.crypto.Sha384Digest;
import java.util.Map;

/**
 *
 * @author dczech
 */
public class MeasurementSha384 extends Measurement<Sha384Digest> {

    public MeasurementSha384(Sha384Digest digest, String label) {
        super(digest, label);
    }

    @JsonCreator
    public MeasurementSha384(@JsonProperty("value") Sha384Digest digest, @JsonProperty("label") String label, @JsonProperty("info") Map<String, String> info) {
        super(digest, label, info);
    }

    @Override
    protected void validateOverride() {
        if(!Sha384Digest.isValid(this.digest.toByteArray())) {
            fault("SHA384 Digest is invalid");
        }
    }

}
