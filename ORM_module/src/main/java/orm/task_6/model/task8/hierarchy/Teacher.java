package orm.task_6.model.task8.hierarchy;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@DiscriminatorValue("T")
public class Teacher extends Person{

    public Teacher(Integer id, String gender, Integer age, String name, String subject, BigDecimal salary) {
        super(id, gender, age, name);
        this.subject = subject;
        this.salary = salary;
    }

    private static final Long serialVersionUID = 4L;
    private String subject;
    private BigDecimal salary;

    @Override
    public String toString() {
        return "Teacher3: " +
                "id=" + super.getId() +
                ", gender='" + super.getGender() + '\'' +
                ", age=" + super.getAge() +
                ", name='" + super.getName() + '\'' +
                ", subject='" + subject + '\'' +
                ", salary=" + salary +
                ';';
    }
}
