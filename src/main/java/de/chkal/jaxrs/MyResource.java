package de.chkal.jaxrs;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
@Produces("text/plain")
public class MyResource {

    @Valid
    @QueryParam("name")
    @Size(min = 100)
    private String name;

    @GET
    public String get() {
        return "Hello " + name;
    }

}
