package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_addess;

    @Column(nullable = false, name = "compagny")
    private String compagny;

    @Column(nullable = false, name = "city")
    private String city;

    @Column(nullable = false, name = "street")
    private String street;


}
