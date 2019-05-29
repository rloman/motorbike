package nl.qien.motorbike;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import nl.qien.motorbike.injecting.MotorServiceInjectDemo;
import nl.qien.motorbike.model.Motorbike;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;

public class MotorbikeXmlParseApp {

    public static void main(String[] args) throws IOException {


        // first, create and write a motorbike to file
        {
            Motorbike motorbike = new Motorbike();
            motorbike.setCc(750);
            motorbike.setBrand("Suzuki");
            motorbike.setColor("Red");

            writeToXml(motorbike);
        }

        //... then read back the motorbike from file
        {

        }


    }

    private static Motorbike readFromFile(String fileName) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        // JSON from file to Object
        Motorbike resume = mapper.readValue(new File(fileName), Motorbike.class);

        return resume;
    }

    private static void writeToXml(Motorbike motorbike) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("motorbike.xml"), motorbike);
    }
}
