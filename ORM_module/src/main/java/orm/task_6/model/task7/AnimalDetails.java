package orm.task_6.model.task7;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AnimalDetails {

    private String gender;

    private String color;

    private Integer height;

    @Override
    public String toString() {
        return "AnimalDetails: " +
                "gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                ';';
    }
}
