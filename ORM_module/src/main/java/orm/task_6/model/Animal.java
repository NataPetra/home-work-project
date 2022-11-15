package orm.task_6.model;

import lombok.*;
import orm.task_6.model.task7.AnimalDetails;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_seq")
    @SequenceGenerator(name = "animal_seq", sequenceName = "animal_seq")
    private Integer id;

    @Column
    private String kindOfAnimal;

    @Column
    private Integer age;

    @Column
    private String nickname;

    private AnimalDetails animalDetails;

    @Override
    public String toString() {
        return "Animal: " +
                "id=" + id +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                ", gender='" + animalDetails.getGender() + '\'' +
                ", color='" + animalDetails.getColor() + '\'' +
                ", height=" + animalDetails.getHeight() +
                ';';
    }
}
