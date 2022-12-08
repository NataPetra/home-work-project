package my.spring.treads;

import my.spring.util.DataConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ThreadsCounter {

    public static void main(String[] args) {
        Counter counter = new Counter(1, 0);

        CounterService service
                = new AnnotationConfigApplicationContext(DataConfig.class, CounterDaoImpl.class, CounterService.class)
                .getBean("counterService", CounterService.class);

        //service.createCount(counter);

        List<Thread> list = new ArrayList<>();

        Runnable r = () -> {
//            for (int i = 0; i < 10; i++) {
                service.updateCount();
                System.out.println("I work");
//            }
        };

        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(r);
            System.out.println("New Thread");
            list.add(thread);
        }
        list.forEach(Thread::start);
    }

}
