package my.spring.task2.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Getter
@Setter
@ToString
public class Animal implements InitializingBean, DisposableBean {

    private String kind;
    private String nickname;
    private Integer age;

    public void init() throws Exception {
        System.out.println("Calling init()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Calling destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Calling setApplicationContext()");
    }
}
