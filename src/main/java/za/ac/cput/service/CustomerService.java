package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService{
    private CustomerRepository customerRepository;

    @Autowired
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer read(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Set<Customer> getAll() {
        return customerRepository.findAll().stream().collect(Collectors.toSet());
    }
}
