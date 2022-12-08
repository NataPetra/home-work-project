package my.spring.task9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomeAddress implements IAddress{

    @Value("Home")
    private String homeAddr;

}
