/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.intel.mtwilson.core.common.utils.MeasurementUtils;
import com.intel.mtwilson.jaxrs2.provider.JacksonObjectMapperProvider;
import com.intel.wml.measurement.xml.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ddhawal
 */
public class MeasurementDeserializer extends JsonDeserializer<Measurement> {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MeasurementDeserializer.class);

    @Override
    public Measurement deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        JsonNode measureNode = jp.getCodec().readTree(jp);
        ObjectMapper mapper = JacksonObjectMapperProvider.createDefaultMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        CumulativeHashType cumulativeHash = new CumulativeHashType();
        List<MeasurementType> measurements = new ArrayList<>();
        for (Iterator<Map.Entry<String, JsonNode>> nodeIterator = measureNode.fields(); nodeIterator.hasNext(); ) {
            Map.Entry<String, JsonNode> nodeEntry = nodeIterator.next();
            /* Process node tree and add following data in nodes,
            * type  : this is used to deserialize data, as file and symlink have same structure
            * value : node reader, reads it as blank key, hence key with name "value" is added
            * CumulativeHash is removed and added to measurement directly as it needs similar format of file or symlink
            * */
            if(nodeEntry.getKey().equals("Dir")) {
                ((ObjectNode)nodeEntry.getValue()).put("type", "directoryMeasurementType");
                ((ObjectNode)nodeEntry.getValue()).put("value", nodeEntry.getValue().get("").asText());
                measurements.add(mapper.readValue(nodeEntry.getValue().toString(), DirectoryMeasurementType.class));
            } else if(nodeEntry.getKey().equals("File")) {
                ((ObjectNode)nodeEntry.getValue()).put("type", "fileMeasurementType");
                ((ObjectNode)nodeEntry.getValue()).put("value", nodeEntry.getValue().get("").asText());
                measurements.add(mapper.readValue(nodeEntry.getValue().toString(), FileMeasurementType.class));
            } else if(nodeEntry.getKey().equals("Symlink")) {
                ((ObjectNode)nodeEntry.getValue()).put("type", "symlinkMeasurementType");
                ((ObjectNode)nodeEntry.getValue()).put("value", nodeEntry.getValue().get("").asText());
                measurements.add(mapper.readValue(nodeEntry.getValue().toString(), SymlinkMeasurementType.class));
            }else if(nodeEntry.getKey().equals("CumulativeHash")) {
                cumulativeHash.setValue(nodeEntry.getValue().asText());
                nodeIterator.remove();
            }
        }

        Measurement measurement = mapper.readValue(measureNode.toString(), Measurement.class);
        measurement.setCumulativeHash(cumulativeHash);
        measurement.getMeasurements().addAll(measurements);
        try {
            log.debug("MeasurementDeserializer: Deserialize Measurement - {}", MeasurementUtils.getMeasurementString(measurement));
        } catch (JAXBException e) {
            log.error("Unable to deserialize Measurement", e);
        }
        return measurement;
    }
}