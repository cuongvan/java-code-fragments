/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetty_embed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cuong
 */
@Path("/test")
public class TestEndpoint {
    @Path("/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@PathParam("id") int id) {
        return "ID: " + id;
    }
}
