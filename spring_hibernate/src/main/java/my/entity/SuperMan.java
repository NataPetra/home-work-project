package my.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "super_man")
public class SuperMan {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nikName;

    private String superPower;

    @Override
    public String toString() {
        return "SuperMan{" +
                "id=" + id +
                ", nikName='" + nikName + '\'' +
                ", superPower='" + superPower + '\'' +
                '}';
    }
}
