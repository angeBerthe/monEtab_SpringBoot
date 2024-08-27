package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@DiscriminatorValue(value = "teacher")
@Entity
public class Teacher extends Person {


    @Column(nullable = false, name = "vacant")
    private Boolean vacant;

    @Column(nullable = false, name = "matiereEnseigne")
    private String matiereEnseigne;



}
