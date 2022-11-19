package orm.task_6.model.task8.concrete;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Student3 extends Person3 {

    public Student3(Integer id, String gender, Integer age, String name, String faculty, Double mark) {
        super(id, gender, age, name);
        this.faculty = faculty;
        this.mark = mark;
    }

    private static final Long serialVersionUID = 3L;
    private String faculty;
    private Double mark;

    @Override
    public String toString() {
        return "Student3: " +
                "id=" + super.getId() +
                ", gender='" + super.getGender() + '\'' +
                ", age=" + super.getAge() +
                ", name='" + super.getName() + '\'' +
                ", faculty='" + faculty + '\'' +
                ", mark=" + mark +
                ';';
    }
}
