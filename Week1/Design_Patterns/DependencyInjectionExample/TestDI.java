package DependencyInjectionExample;

public class TestDI {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.getCustomerDetails("CUST1001");
    }
}
