package nl.qien.motorbike.feign;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import nl.qien.motorbike.model.Motorbike;

import java.util.List;

public class FeignDemoApp {

    private static final String API = "http://localhost:8080/api/motorbikes";

    public static void main(String[] args) {
        MotorbikeClient motorbikeClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(MotorbikeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(MotorbikeClient.class, API);

        // vanaf hier is mijn REST service zichtbaar als
        // normale java code

        List<Motorbike> allMotorbikes = motorbikeClient.findAll();

        System.out.println(allMotorbikes);

        allMotorbikes.forEach(motorbike -> {
            System.out.println(motorbike);
        });

        int actualSize = allMotorbikes.size();

        // create a motorbike
        Motorbike newMotorbike = new Motorbike();
        newMotorbike.setOwner("Francien");
        newMotorbike.setColor("Red");
        newMotorbike.setCc(750);

        // create / post the motorbike
        motorbikeClient.create(newMotorbike);

        allMotorbikes = motorbikeClient.findAll();

        System.out.println(allMotorbikes);

        allMotorbikes.forEach(motorbike -> {
            System.out.println(motorbike);
        });

        assertTrue( allMotorbikes.size() == actualSize+1);

    }

    private static void assertTrue(boolean b) {
        if(!b) {
            throw new AssertionError();
        }
    }
}
