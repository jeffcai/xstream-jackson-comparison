package com.jeffcaijf.serialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jeffcaijf.model.Form;
import com.jeffcaijf.model.Group;
import com.jeffcaijf.model.Section;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;


public class JSONConverter {

    private static XStream xstream = null;
    private static ObjectMapper mapper = null;

    public static void main(String[] args) throws JsonProcessingException {
        Form form = new Form();
        long start = System.currentTimeMillis();
        createXStream().toXML(form);
        long end = System.currentTimeMillis();
        System.out.println("XStream 1st execution duration: " + (Long.valueOf(end) - Long.valueOf(start)));

        start = System.currentTimeMillis();
        String xstreamXML = createXStream().toXML(form);
        end = System.currentTimeMillis();
        System.out.println("XStream 2nd execution duration: " + (Long.valueOf(end) - Long.valueOf(start)));
        System.out.println(xstreamXML);

        start = System.currentTimeMillis();
        createObjectMapper().writeValueAsString(form);
        end = System.currentTimeMillis();
        System.out.println("Jackson 1st duration: " + (Long.valueOf(end) - Long.valueOf(start)));

        start = System.currentTimeMillis();
        String jacksonXML = createObjectMapper().writeValueAsString(form);
        end = System.currentTimeMillis();
        System.out.println("Jackson 2nd duration: " + (Long.valueOf(end) - Long.valueOf(start)));
        System.out.println(jacksonXML);
    }


    private static XStream createXStream() {
        if (xstream == null) {
            xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.alias("Form", Form.class);
            xstream.alias("Group", Group.class);
            xstream.alias("Section", Section.class);
            xstream.setMode(XStream.NO_REFERENCES);
        }
        return xstream;
    }

    private static ObjectMapper createObjectMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.enable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            mapper.enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, "@class");
        }
        return mapper;
    }

}
