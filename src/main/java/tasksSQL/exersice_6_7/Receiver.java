package tasksSQL.exersice_6_7;

import java.io.Serializable;

public class Receiver implements Serializable {

    private int num;
    private String name;

    public Receiver() {
    }

    public Receiver(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Receiver:" +
                "num=" + num +
                ", name='" + name + '\'' +
                ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receiver receivers = (Receiver) o;

        if (num != receivers.num) return false;
        return name != null ? name.equals(receivers.name) : receivers.name == null;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
