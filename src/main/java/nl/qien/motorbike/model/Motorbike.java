package nl.qien.motorbike.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;

@Entity
public class Motorbike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Color color;
    private String brand;
    private String type;



}
