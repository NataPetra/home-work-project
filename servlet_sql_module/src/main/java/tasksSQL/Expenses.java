package tasksSQL;

import java.io.Serializable;

public class Expenses implements Serializable {

    private int id;
    private String payDate;
    private String receiver;
    private double value;

    public Expenses() {
    }

    public Expenses(int id, String payDate, String receiver, double value) {
        this.id = id;
        this.payDate = payDate;
        this.receiver = receiver;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expenses: " +
                "id=" + id +
                ", date='" + payDate + '\'' +
                ", receiver='" + receiver + '\'' +
                ", value=" + value +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expenses expenses = (Expenses) o;

        if (id != expenses.id) return false;
        if (Double.compare(expenses.value, value) != 0) return false;
        if (payDate != null ? !payDate.equals(expenses.payDate) : expenses.payDate != null) return false;
        return receiver != null ? receiver.equals(expenses.receiver) : expenses.receiver == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
