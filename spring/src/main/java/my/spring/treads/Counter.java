package my.spring.treads;

import lombok.*;
import my.spring.util.DataConfig;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "counter")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Counter implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    @Column
    private int count;


}
