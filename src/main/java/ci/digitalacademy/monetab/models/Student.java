package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@DiscriminatorValue(value = "student")
@Entity
public class Student extends Person {

    @Column(nullable = false, name = "classe")
    private String classe;

    @Column(nullable = false, name = "matricule", unique = true)
    private String matricule;

}
