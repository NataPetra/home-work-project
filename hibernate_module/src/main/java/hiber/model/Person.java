package hiber.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer age;

    @Column
    private String name;

    @Column
    private String surname;
}
