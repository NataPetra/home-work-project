package orm.task_6.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Man implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @Column
    private Integer age;

    @Column
    private String name;

    @Column
    private String surname;

}
