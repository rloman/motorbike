package nl.qien.motorbike.api;

import nl.qien.motorbike.model.Car;
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
public class CarEndpoint {


    @GET
    public Response get() {


        List<Car> result = new ArrayList<>();

        result.addAll(Arrays.asList(new Car("A"), new Car("B"), new Car("C")));

        return Response.ok(result).build();


    }

}
