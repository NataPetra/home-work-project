package tasksSQL;

import java.util.List;

public interface ExpensesDao {

    void create(Expenses expenses);

    List<Expenses> readAll();

    void update(Expenses expenses);

    void delete(Expenses expenses);
}
