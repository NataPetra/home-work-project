package tasksSQL.exersice_6_7;

import java.io.Serializable;
import java.math.BigDecimal;

public class Expense implements Serializable {

    private int id;
    private String pay_date;
    private int receiver_id;
    private BigDecimal value;

    public Expense() {
    }

    public Expense(int id, String payDate, int receiver_id, BigDecimal value) {
        this.id = id;
        this.pay_date = payDate;
        this.receiver_id = receiver_id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expense:" +
                "id=" + id +
                ", payDate='" + pay_date + '\'' +
                ", receiver_id=" + receiver_id +
                ", value=" + value +
                ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (id != expense.id) return false;
        if (receiver_id != expense.receiver_id) return false;
        if (pay_date != null ? !pay_date.equals(expense.pay_date) : expense.pay_date != null) return false;
        return value != null ? value.equals(expense.value) : expense.value == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pay_date != null ? pay_date.hashCode() : 0);
        result = 31 * result + receiver_id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
