package nl.qien.motorbike.model;

import lombok.Data;

import javax.persistence.*;

//@MappedSuperclass
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
