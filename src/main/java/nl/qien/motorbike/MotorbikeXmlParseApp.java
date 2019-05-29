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

import java.io.*;

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
            Motorbike readBack = readFromFile("motorbike.xml");

            System.out.println(readBack);
        }


    }

    private static Motorbike readFromFile(String fileName) throws JsonParseException, JsonMappingException, IOException {
        File file = new File("motorbike.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        Motorbike value = xmlMapper.readValue(xml, Motorbike.class);

        return value;
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    private static void writeToXml(Motorbike motorbike) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("motorbike.xml"), motorbike);
    }
}
