package my.spring.loader;

import my.spring.beans.Animal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Animal animal = context.getBean("animal", Animal.class);
        System.out.println(animal);
        context.close();
    }
}
