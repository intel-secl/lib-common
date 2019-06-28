/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.validators;

import com.intel.dcsg.cpg.validation.InputValidator;
import com.intel.dcsg.cpg.xml.JAXB;
import com.intel.wml.measurement.xml.Measurement;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 *
 * @author ddhawal
 */
public class MeasurementValidator extends InputValidator<String> {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MeasurementValidator.class);

    @Override
    protected void validate() {
        String input = getInput();
        if (input != null && !input.isEmpty()) {
            try {
                JAXB measurementJaxb = new JAXB();
                measurementJaxb.read(input, Measurement.class);
            } catch (IOException | JAXBException | XMLStreamException ex) {
                log.error("Measurement string specified is invalid. {}", ex.getMessage());
                fault(ex, "Invalid measurement");
            }
        }
    }
}
