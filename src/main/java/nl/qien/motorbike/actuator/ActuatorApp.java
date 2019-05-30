package nl.qien.motorbike.actuator;

public class ActuatorApp {

    public static void main(String[] args) {

        System.out.println("To use the actuator");
        System.out.println("add the dependency to Maven pom");
        System.out.println(" <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-actuator</artifactId>\n" +
                "        </dependency>" +
                "\n");
        System.out.println("Add the following lines in the application.properties");
        System.out.println("" +
                "# to tell that we are exposing the actual beans and more behind /actuator url\n"+
                "management.context-path=/actuator\n\n" +
                "# to tell that security is not enabled (so disabled) for this part\n"+
                "management.security.enabled=false\n" +
                "\n" +
                "# that we want to expose all endpoints (later more on that)\n"+
                "management.endpoints.web.exposure.include=*");

        System.out.println();
        System.out.println("More on this link: http://springboot.carpago.nl/exercises.adoc/actuator.html");
        System.out.println("And this link: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html");
        System.out.println("And this link: https://www.baeldung.com/spring-boot-actuators");


        System.out.println();
        System.out.println("Suggested endpoints:");
        System.out.println("/actuator/beans// prints all beans including all @Components, so also inclucing @Service, @RestController, ...");
        System.out.println("/actuator/mappings // prints all @RequestMapping endpoints!!! Great!!!");

        System.out.println();
        System.out.println();

        System.out.println("So ... assignment ... add the or test the actuator in your personal app");
    }
}
