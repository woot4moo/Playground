package com.example.converter;

import com.example.model.Text;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Resides between the service and model layers to enable conversion from HTTP requests into something
 * we can use in the backend.
 *
 * @see org.codehaus.jackson.map.ObjectMapper
 */
public final class TextConverter {

    private final ObjectMapper mapper;

    public TextConverter(){
        mapper = new ObjectMapper();
    }

    /**
     * At the moment just stubbed, but during normal use will produce a correctly
     * generated {@link Text}
     *
     * @return - a correctly mapped Text
     */
    public Text fromRest(String json) throws IOException {
        Text toReturn = mapper.readValue(json,Text.class);
        return toReturn;
    }

    public static void main(String[] args) throws Exception{
        Text toWrite = new Text();
        TextConverter tc = new TextConverter();
        System.out.println(tc.mapper.writeValueAsString(toWrite));
        String json = "{\"recordId\":null,\"textId\":null,\"name\":null,\"value\":null,\"position\":0}";
        System.out.println(tc.fromRest(json));
    }
}
