package my.load;

import my.config.DataConfig;
import my.dao.SuperManDaoImpl;
import my.entity.SuperMan;
import my.service.SuperManService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationContext
                = new AnnotationConfigApplicationContext(
                        DataConfig.class,
                        SuperManDaoImpl.class,
                        SuperManService.class);

        SuperManService service = annotationContext.getBean("superManService", SuperManService.class);
        SuperMan superMan = new SuperMan(null, "Nik", "Fly");
        System.out.println(superMan);
        service.newSuperMan(superMan);
        SuperMan superManFromDB = service.getSuperMan(1);
        System.out.println(superManFromDB);
        annotationContext.close();
    }
}
