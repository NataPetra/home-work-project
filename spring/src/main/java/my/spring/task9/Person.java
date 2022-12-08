package my.spring.task9;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Person {

    @Value("Nata")
    private String name;

    @Autowired
    @Qualifier("homeAddress")
    private IAddress iAddress;

}
