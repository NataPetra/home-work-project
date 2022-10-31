package tasksSQL.exersice_6_7;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExpenseAndReceiverDao {

    Receiver getReceiver(int num);

    List<Receiver> getReceivers();

    Expense getExpense(int id);

    List<Expense> getExpenses();

    void addExpense(Expense expense);

    void addReceiver(Receiver receiver);

    Map<String, BigDecimal> amountOfPaymentsByReceivers();

    String amountPerDayWithTheHighestPayment();

    String largestPaymentForTheLargestAmount();
}
