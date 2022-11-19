package orm.task_6.model.task8.hierarchy;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@DiscriminatorValue("S")
public class Student extends Person{

    public Student(Integer id, String gender, Integer age, String name, String faculty, Double mark) {
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
