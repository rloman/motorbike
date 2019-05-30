package nl.qien.motorbike.feign;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import nl.qien.motorbike.model.Motorbike;

import java.util.List;

public interface MotorbikeClient {

    @RequestLine("GET")
    List<Motorbike> findAll();

    @RequestLine("GET /{id}")
    Motorbike findById(@Param("id") long id);

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(Motorbike user);
}
