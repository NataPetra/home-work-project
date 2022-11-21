package tasksSQL.exersice_6_7;

public class MainTest {

    public static void main(String[] args) {
        ExpenseAndReceiverDaoImpl dao = ExpenseAndReceiverDaoImpl.getInstance();
//        System.out.println(dao.amountOfPaymentsByReceivers());
//        System.out.println(dao.amountPerDayWithTheHighestPayment());
//        System.out.println(dao.largestPaymentForTheLargestAmount());
        //dao.getExpenses().forEach(System.out::println);
        System.out.println(dao.getReceiver(1));
        //dao.getReceivers().forEach(System.out::println);

    }
}
