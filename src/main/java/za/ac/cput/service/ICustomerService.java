package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface ICustomerService extends IService<Customer, Long>{
    Customer update(Customer customer);
    Set<Customer> getAll();
}
