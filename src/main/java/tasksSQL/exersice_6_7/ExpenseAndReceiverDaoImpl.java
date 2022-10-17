package tasksSQL.exersice_6_7;

import tasksSQL.Expenses;
import tasksSQL.MysqlConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseAndReceiverDaoImpl implements ExpenseAndReceiverDao {

    private static ExpenseAndReceiverDaoImpl INSTANCE;
    private MysqlConnection dataSource;
    public static final String EXPENSE_CREATE = "INSERT INTO expense (id, pay_date, receiver_id, value) VALUES (?, ?, ?, ?)";
    public static final String RECEIVER_CREATE = "INSERT INTO receiver (num, name) VALUES (?, ?)";

    private ExpenseAndReceiverDaoImpl() {
        try {
            this.dataSource = new MysqlConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ExpenseAndReceiverDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ExpenseAndReceiverDaoImpl();
        }
        return INSTANCE;
    }

    @Override
    public Receiver getReceiver(int num) {
        Receiver receiver = new Receiver();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT num, name FROM receiver WHERE num=" + num + ";");
            receiver.setNum(resultSet.getInt("num"));
            receiver.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receiver;
    }

    @Override
    public List<Receiver> getReceivers() {
        List<Receiver> receivers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT num, name FROM receiver");
            while (resultSet.next()) {
                final Receiver receiver = new Receiver();
                receiver.setNum(resultSet.getInt("num"));
                receiver.setName(resultSet.getString("name"));
                receivers.add(receiver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receivers;
    }

    @Override
    public Expense getExpense(int id) {
        Expense expense = new Expense();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT id, pay_date, receiver_id, value FROM expense WHERE id=" + id + ";");
            expense.setId(resultSet.getInt("id"));
            expense.setPay_date(resultSet.getString("pay_date"));
            expense.setReceiver_id(resultSet.getInt("receiver_id"));
            expense.setValue(resultSet.getBigDecimal("value"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public List<Expense> getExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT id, pay_date, receiver_id, value FROM expense");
            while (resultSet.next()) {
                final Expense expense = new Expense();
                expense.setId(resultSet.getInt("id"));
                expense.setPay_date(resultSet.getString("pay_date"));
                expense.setReceiver_id(resultSet.getInt("receiver_id"));
                expense.setValue(resultSet.getBigDecimal("value"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public void addExpense(Expense expense) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EXPENSE_CREATE);) {
            preparedStatement.setInt(1, expense.getId());
            preparedStatement.setString(2, expense.getPay_date());
            preparedStatement.setInt(3, expense.getReceiver_id());
            preparedStatement.setBigDecimal(4, expense.getValue());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addReceiver(Receiver receiver) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(RECEIVER_CREATE);) {
            preparedStatement.setInt(1, receiver.getNum());
            preparedStatement.setString(2, receiver.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, BigDecimal> amountOfPaymentsByReceivers() {
        Map<String, BigDecimal> map = new HashMap<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT r.name, IFNULL(sum(e.value), 0) FROM test.receiver r \n" +
                    "LEFT JOIN test.expense e on r.num=e.receiver_id group by r.name;");
            while (resultSet.next()) {
                map.put(resultSet.getString("name"), resultSet.getBigDecimal("IFNULL(sum(e.value), 0)"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public String amountPerDayWithTheHighestPayment() {
        String result = "";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT SUM(e.value), pay_date " +
                    "FROM test.expense e " +
                    "WHERE pay_date IN (" +
                    "SELECT pay_date " +
                    "FROM test.expense " +
                    "WHERE value IN (" +
                    "SELECT MAX(value) " +
                    "FROM test.expense)) " +
                    "GROUP BY pay_date;");
            while (resultSet.next()) {
                result = resultSet.getString("pay_date") + " = " + resultSet.getBigDecimal("SUM(e.value)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String largestPaymentForTheLargestAmount() {
        String result = "";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT pay_date, MAX(e.value) " +
                    "FROM test.expense e " +
                    "GROUP BY pay_date " +
                    "HAVING SUM(e.value)=(" +
                    "SELECT SUM(e2.value) " +
                    "FROM test.expense e2 " +
                    "GROUP BY pay_date " +
                    "ORDER BY SUM(e2.value) DESC " +
                    "LIMIT 1);");
            while (resultSet.next()) {
                result = resultSet.getString("pay_date") + " = " + resultSet.getBigDecimal("MAX(e.value)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
