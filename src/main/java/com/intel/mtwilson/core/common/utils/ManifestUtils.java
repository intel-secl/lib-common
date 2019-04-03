package com.intel.mtwilson.core.common.utils;

import com.intel.dcsg.cpg.xml.JAXB;
import com.intel.wml.manifest.xml.Manifest;

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
public class ManifestUtils {
    public static Manifest parseManifestXML(String manifest) throws JAXBException, IOException, XMLStreamException {
        JAXB manifestJaxb = new JAXB();
        return manifestJaxb.read(manifest, Manifest.class);
    }

    //Convert manifest xml to string
    public static String getManifestString(Manifest manifest) throws JAXBException{
        StringWriter tempManifest = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Manifest.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(manifest, tempManifest);
        return tempManifest.toString();
    }
}
