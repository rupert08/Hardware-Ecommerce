package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface ICustomerService extends IService<Customer, Long>{
    Set<Customer> getAll();

    Customer findByUsernameAndPassword(String username, String password);
}

