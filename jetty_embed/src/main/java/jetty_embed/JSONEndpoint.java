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
@Path("/json")
public class JSONEndpoint {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person test() {
        Person p = new Person();
        p.name = "Van tien cuong";
        p.age = 2;
        return p;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person echo(Person person) {
        return person;
    }
    
    
}
