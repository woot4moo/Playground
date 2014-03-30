package com.example.service.rest;

import com.example.model.Text;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *  Service provider for records.
 *
 *  @see com.example.model.jpa.Record
 */
@Path("/records")
public class RecordService {

    @GET
    @Path("/record")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Text printRecord(){
        Text text = new Text();
        text.setName("Name");
        return text;
    }

    @POST
    @Path("/foo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response print(@QueryParam("record") String record){
        System.out.println("Rest record: " + record);
        return Response.status(200).entity(record).build();
    }
}
