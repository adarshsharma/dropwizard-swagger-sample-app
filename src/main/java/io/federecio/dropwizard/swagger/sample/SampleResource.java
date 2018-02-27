package io.federecio.dropwizard.swagger.sample;

import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Federico Recio
 */
@Path("/sample")
@Api("/sample")
public class SampleResource {

    @GET
    @ApiOperation("Sample endpoint")
    public Response get() {
        return Response.ok(new SamplePojo("Federico", 1234)).build();
    }

    @GET
    @ApiOperation("Sample endpoint with path param")
    @Path("/hello-with-path-param/{name}")
    public Response getWithPathParam(@PathParam("name") String name) {
        return Response.ok(new SamplePojo("Hello " + name, 333)).build();
    }

    @GET
    @ApiOperation("Sample endpoint with query param")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied", response = ErrorPojo.class),
            @ApiResponse(code = 200, message = "success", response = SamplePojo.class) })
    @Path("/hello-with-query-param")
    public Response getWithQueryParam(@QueryParam("name") String name) {
        return Response.ok(new SamplePojo("Hello " + name, 444)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Get access token",
            notes = "Authenticate user and get a access token.",
            response = SamplePojo.class
    )
    public SamplePojo postForToken(
            @FormParam("username") @ApiParam(defaultValue = "username", required = true) String username,
            @FormParam("password") @ApiParam(defaultValue = "q", required = true) String password,
            @ApiParam(value = "Updated user object", required = true) SampleRequest sampleRequest
    ) {
        return new SamplePojo(username, 1234);
    }
}
