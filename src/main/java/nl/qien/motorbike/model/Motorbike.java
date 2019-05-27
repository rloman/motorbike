package nl.qien.motorbike.model;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Motorbike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String color;
    private String brand;
    private String type;
    private int cc;

}
