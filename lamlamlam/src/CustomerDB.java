import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

    private static final List<Customer> customers = new ArrayList<Customer>();

    static {
        Customer customer1 = new Customer("lam", "0982162220", "London");
        Customer customer2 = new Customer("hieu", "0962162220", "London");
        Customer customer3 = new Customer("tuan", "0916222001", "London");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    public static List<Customer> queryCustomer() {
        return customers;
    }

}
