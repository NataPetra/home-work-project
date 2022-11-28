package my.spring.loader;

import my.spring.task2.beans.Animal;
import my.spring.task7.beans.Parent;
import my.spring.task8.Seller;
import my.spring.task8.Shop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Animal animal = context.getBean("animal", Animal.class);
        System.out.println(animal);

        Parent parent = context.getBean("parent", Parent.class);
        Parent parent2 = context.getBean("parent2", Parent.class);
        Parent parent3 = context.getBean("parent3", Parent.class);
        Parent parent4 = context.getBean("parent4", Parent.class);
        System.out.println(parent + "\n" + parent2 + "\n" + parent3 + "\n" + parent4);

        context.close();

        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(Shop.class, Seller.class);

        Shop shop = annotationContext.getBean("shop", Shop.class);
        System.out.println(shop);
        annotationContext.close();
    }
}
