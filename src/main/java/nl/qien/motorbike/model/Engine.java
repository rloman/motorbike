package nl.qien.motorbike.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Engine {

    private long id;

    private int cc;
    private double temperature;
}
