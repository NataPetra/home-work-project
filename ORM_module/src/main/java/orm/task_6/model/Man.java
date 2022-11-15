package orm.task_6.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import orm.task_6.model.task7.ManDetails;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
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

    @Embedded
    private ManDetails manDetails;

    @Override
    public String toString() {
        return "Man: " +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + manDetails.getHeight() +
                ", weight=" + manDetails.getWeight() +
                ", eyesColor='" + manDetails.getEyesColor() + '\'' +
                ";";
    }
}
