package tasksSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao{

    public static final String EXPENSES_CREATE = "INSERT INTO expenses (id, data, receiver, value) VALUES (?, ?, ?, ?)";
    private MysqlConnection dataSource;

    public ExpensesDaoImpl() {
        try {
            this.dataSource = new MysqlConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Expenses expenses) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EXPENSES_CREATE);) {
            preparedStatement.setInt(1, expenses.getId());
            preparedStatement.setString(2, expenses.getPayDate());
            preparedStatement.setString(3, expenses.getReceiver());
            preparedStatement.setDouble(4, expenses.getValue());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Expenses> readAll() {
        List<Expenses> expenses = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT id, data, receiver, value FROM expenses");
            while (resultSet.next()) {
                final Expenses expense = new Expenses();
                expense.setId(resultSet.getInt("id"));
                expense.setPayDate(resultSet.getString("data"));
                expense.setReceiver(resultSet.getString("receiver"));
                expense.setValue(resultSet.getDouble("value"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public void update(Expenses expenses) {

    }

    @Override
    public void delete(Expenses expenses) {

    }
}
