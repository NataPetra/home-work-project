package orm.task_6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
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
}
