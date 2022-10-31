package tasksSQL;

import java.util.List;

public class PassingArgumentsMain {

    public static void main(String[] args) {
        int id = Integer.parseInt(args[0]);
        String data = args[1];
        String receiver = args[2];
        double value = Double.parseDouble(args[3]);

        Expenses expenses = new Expenses(id, data, receiver, value);
        ExpensesDao expensesDao = new ExpensesDaoImpl();
        expensesDao.create(expenses);
        List<Expenses> expensesList = expensesDao.readAll();
        for (Expenses expense : expensesList) {
            System.out.println(expense);
        }

    }
}
