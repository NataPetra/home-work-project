package my.spring.task8;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Seller {

    @Value("Andy")
    private String firstName;

    @Value("1000000.0")
    private Double salary;

}
