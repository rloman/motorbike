package nl.qien.motorbike.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Motorbike extends Vehicle{



    private String color;
    private String brand;
    private String type;
    private int cc;

    private String owner;

}
