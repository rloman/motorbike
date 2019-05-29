package nl.qien.motorbike.model;

public class Application {

    public static void main(String[] args) {
        Engine e = Engine.builder().cc(500).id(3).temperature(90.0).build();

        System.out.println(e.getCc());
    }
}
