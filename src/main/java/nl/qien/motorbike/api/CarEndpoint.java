package nl.qien.motorbike.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.qien.motorbike.model.Car;
import nl.qien.motorbike.model.Motorbike;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("cars")
@Api(value = "Hello API - say hello to the world", produces = "application/json")
public class CarEndpoint {


    @ApiOperation(            //Swagger Annotation
            value = "Say hello by entering your name",
            response = Motorbike.class)
    @ApiResponses(value = {       //Swagger Annotation
            @ApiResponse(code = 200, message = "Resource found"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    @GET
    public Response get() {


        List<Car> result = new ArrayList<>();

        result.addAll(Arrays.asList(new Car("A"), new Car("B"), new Car("C")));

        return Response.ok(result).build();


    }

}
