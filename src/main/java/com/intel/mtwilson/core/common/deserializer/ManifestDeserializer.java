/*
 * Copyright (C) 2018 Intel Corporation
 * All rights reserved.
 */
package com.intel.mtwilson.core.common.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.intel.mtwilson.core.common.utils.ManifestUtils;
import com.intel.mtwilson.jaxrs2.provider.JacksonObjectMapperProvider;
import com.intel.wml.manifest.xml.*;

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
public class ManifestDeserializer extends JsonDeserializer<Manifest> {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ManifestDeserializer.class);

    @Override
    public Manifest deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        JsonNode manifestNode = jp.getCodec().readTree(jp);
        ObjectMapper mapper = JacksonObjectMapperProvider.createDefaultMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        List<ManifestType> manifests = new ArrayList<>();
        for (Iterator<Map.Entry<String, JsonNode>> nodeIterator = manifestNode.fields(); nodeIterator.hasNext(); ) {
            Map.Entry<String, JsonNode> nodeEntry = nodeIterator.next();
            /* Process node tree and add following data in nodes,
             * type  : this is used to deserialize data, as file and symlink have same structure
             * */
            if(nodeEntry.getKey().equals("Dir")) {
                ((ObjectNode)nodeEntry.getValue()).put("type", "dir");
                manifests.add(mapper.readValue(nodeEntry.getValue().toString(), Dir.class));
            } else if(nodeEntry.getKey().equals("File")) {
                ((ObjectNode)nodeEntry.getValue()).put("type", "file");
                manifests.add(mapper.readValue(nodeEntry.getValue().toString(), File.class));
            } else if(nodeEntry.getKey().equals("Symlink")) {
                ((ObjectNode)nodeEntry.getValue()).put("type", "symlink");
                manifests.add(mapper.readValue(nodeEntry.getValue().toString(), Symlink.class));
            }
        }
        Manifest manifest = mapper.readValue(manifestNode.toString(), Manifest.class);
        manifest.getManifests().addAll(manifests);
        try {
            log.debug("ManifestDeserializer: Deserialize manifest - {}", ManifestUtils.getManifestString(manifest));
        } catch (JAXBException e) {
            log.error("Unable to deserialize manifest", e);
        }
        return manifest;
    }
}