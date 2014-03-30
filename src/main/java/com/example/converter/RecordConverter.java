package com.example.converter;

import com.example.model.Record;
import com.example.model.Text;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Converts {@link com.example.model.Record} from service tier into models that are
 * usable.
 *
 * @see com.example.service.rest.RecordService
 */
public final class RecordConverter {

    private final ObjectMapper mapper;

    public RecordConverter(){
        mapper = new ObjectMapper();
    }

    /**
     * At the moment just stubbed, but during normal use will produce a correctly
     * generated {@link com.example.model.Record}
     *
     * @return - a correctly mapped Record
     */
    public Record fromRest(String json) throws IOException {
        Record toReturn = mapper.readValue(json,Record.class);
        return toReturn;
    }

    public static void main(String[] args) throws Exception{
        Record toWrite = new Record();
        Collection<Text> texts = new LinkedList<>();
        for(int i = 0; i < 2; i++){
            Text toAdd = new Text();
            toAdd.setName("foo"+i);
            toAdd.setValue("bar"+i);
            texts.add(toAdd);
        }
        toWrite.setTexts(texts);
        RecordConverter rc = new RecordConverter();
        System.out.println(rc.mapper.writeValueAsString(toWrite));
        String json = "{\"texts\":[{\"recordId\":null,\"textId\":null,\"name\":\"foo0\",\"value\":\"bar0\",\"position\":0},{\"recordId\":null,\"textId\":null,\"name\":\"foo1\",\"value\":\"bar1\",\"position\":0}]}";
        System.out.println(rc.fromRest(json));
    }
}
