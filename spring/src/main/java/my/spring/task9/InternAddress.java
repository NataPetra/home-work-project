package my.spring.task9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InternAddress implements IAddress{

    @Value("Intr")
    private String internAddr;

}
