/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.utils;

import com.intel.dcsg.cpg.xml.JAXB;
import com.intel.wml.measurement.xml.Measurement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.StringWriter;

/**
 *
 * @author ddhawal
 */
public class MeasurementUtils {
    public static Measurement parseMeasurementXML(String measurement) throws JAXBException, IOException, XMLStreamException {
        JAXB measurementJaxb = new JAXB();
        return measurementJaxb.read(measurement, Measurement.class);
    }

    //Convert measurement xml to string
    public static String getMeasurementString(Measurement measurement) throws JAXBException {
        StringWriter tempMeasurement = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Measurement.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(measurement, tempMeasurement);
        return tempMeasurement.toString();
    }
}
