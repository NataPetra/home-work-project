package my.spring.treads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CounterService {

    @Autowired
    private CounterDaoImpl counterDaoImpl;

    @Transactional
    public void createCount(Counter counter){
        counterDaoImpl.create(counter);
    }

    @Transactional
    public void updateCount(){
        counterDaoImpl.update();
    }
}
