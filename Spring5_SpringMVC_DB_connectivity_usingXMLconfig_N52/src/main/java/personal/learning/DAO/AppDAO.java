package personal.learning.DAO;

import java.util.List;

import personal.learning.model.Customer;

public interface AppDAO {
	List<Customer> listCustomers();
	void saveCustomer(Customer customer);
	void removeCustomer(String email);
}
