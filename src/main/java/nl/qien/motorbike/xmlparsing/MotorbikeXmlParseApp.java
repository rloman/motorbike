package nl.qien.motorbike.xmlparsing;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import nl.qien.motorbike.model.Motorbike;

import java.io.*;

/*
This class SHOWS A WAY to write an Object (Motorbike) to file and vice versa
 */
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

    public static void writeToJson(Motorbike motorbike) {
		// TODO 
    }

    public static void writeToXml(Motorbike motorbike) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("motorbike.xml"), motorbike);
    }

    public static Motorbike readFromFile(String fileName) throws JsonParseException, JsonMappingException, IOException {
        File file = new File(fileName);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = getStringFromInputStream(new FileInputStream(file));
        Motorbike motorbike = xmlMapper.readValue(xml, Motorbike.class);

        return motorbike;
    }

    private static String getStringFromInputStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
