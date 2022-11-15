package orm.task_6.model.task7;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManDetails {

    private Integer height;

    private Integer weight;

    private String eyesColor;

    @Override
    public String toString() {
        return "ManDetails: " +
                "height=" + height +
                ", weight=" + weight +
                ", eyesColor='" + eyesColor + '\'' +
                ';';
    }
}
