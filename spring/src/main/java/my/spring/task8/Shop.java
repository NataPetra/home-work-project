package my.spring.task8;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Shop {

    @Value("MiniMarket")
    private String name;

    @Autowired
    private Seller seller;

    //ЭТО НУЖНО ИЛИ НЕТ?
//    @Bean
//    public Shop getShop() {
//        return new Shop(name, seller);
//    }
}
