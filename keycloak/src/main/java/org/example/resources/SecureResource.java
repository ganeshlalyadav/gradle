package org.example.resources;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/secure")
@RolesAllowed("user")
public class SecureResource {
    @GET
    public Response getSecureData() {
        return Response.ok("This is a secure endpoint!").build();
    }
}
