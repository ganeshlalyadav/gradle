package org.example.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/public")
public class PublicResource {

    @GET
    public Response getPublicData() {
        return Response.ok("This is a public endpoint!").build();
    }
}
