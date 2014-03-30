package com.example.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Response printRecord(){
        String x = "hello";
        return Response.status(200).entity(x).build();
    }
}
