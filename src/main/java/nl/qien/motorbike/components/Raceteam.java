package nl.qien.motorbike.components;

import nl.qien.motorbike.model.Motorbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Raceteam {

    @Autowired
    private Motorbike jeroen;

    @Autowired
    private Motorbike roy;

    @Autowired
    private Motorbike jasper;

    public Motorbike getJeroen() {
        return jeroen;
    }

    public Motorbike getRoy() {
        return roy;
    }

    public Motorbike getJasper() {
        return jasper;
    }

    @Override
    public String toString() {
        return "Raceteam{" +
                "jeroen=" + jeroen +
                '}';
    }
}
