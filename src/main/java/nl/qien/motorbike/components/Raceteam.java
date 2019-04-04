package nl.qien.motorbike.components;

import nl.qien.motorbike.model.Motorbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Raceteam {

    @Autowired
    private Motorbike jeroen;

    public Motorbike getJeroen() {
        return jeroen;
    }

    @Override
    public String toString() {
        return "Raceteam{" +
                "jeroen=" + jeroen +
                '}';
    }
}
