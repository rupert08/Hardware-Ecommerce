package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.util.Helper;

import java.util.Optional;
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
        if (customerRepository.existsById(customer.getUserId())) {
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Set<Customer> getAll() {
        return customerRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        return customerRepository.findByUsernameAndPassword(username,password);
    }

    public Customer partialUpdate(Customer customer) {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(customer.getUserId());
        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();

            Customer.Builder builder = new Customer.Builder().copy(existingCustomer);

            if (customer.getFirstName() != null) {
                builder.setFirstName(customer.getFirstName());
            }
            if (customer.getLastName() != null) {
                builder.setLastName(customer.getLastName());
            }
            if (customer.getUsername() != null) {
                builder.setUsername(customer.getUsername());
            }
            if (customer.getPassword() != null) {
                builder.setPassword(customer.getPassword());
            }
            if (customer.getRole() != null) {
                builder.setRole(customer.getRole());
            }
            if (customer.getContact() != null) {
                Contact existingContact = existingCustomer.getContact();
                Contact newContact = customer.getContact();
                Contact.Builder contactBuilder = new Contact.Builder().copy(existingContact);

                if (newContact.getEmail() != null) {
                    contactBuilder.setEmail(newContact.getEmail());
                }
                if (newContact.getPhoneNumber() != null) {
                    contactBuilder.setPhoneNumber(newContact.getPhoneNumber());
                }

                builder.setContact(contactBuilder.build());
            }
            if (customer.getAddress() != null) {
                Address existingAddress = existingCustomer.getAddress();
                Address newAddress = customer.getAddress();
                Address.Builder addressBuilder = new Address.Builder().copy(existingAddress);

                if (newAddress.getStreetNumber() != null) {
                    addressBuilder.setStreetNumber(newAddress.getStreetNumber());
                }
                if (newAddress.getUnitNumber() != null) {
                    addressBuilder.setUnitNumber(newAddress.getUnitNumber());
                }
                if (newAddress.getComplexNumber() != null) {
                    addressBuilder.setComplexNumber(newAddress.getComplexNumber());
                }
                if (newAddress.getComplexName() != null) {
                    addressBuilder.setComplexName(newAddress.getComplexName());
                }
                if (newAddress.getApartmentNumber() != null) {
                    addressBuilder.setApartmentNumber(newAddress.getApartmentNumber());
                }
                if (newAddress.getStreetName() != null) {
                    addressBuilder.setStreetName(newAddress.getStreetName());
                }
                if (newAddress.getCity() != null) {
                    addressBuilder.setCity(newAddress.getCity());
                }
                if (newAddress.getState() != null) {
                    addressBuilder.setState(newAddress.getState());
                }
                if (newAddress.getPostalCode() != null) {
                    addressBuilder.setPostalCode(newAddress.getPostalCode());
                }

                builder.setAddress(addressBuilder.build());
            }

            return customerRepository.save(builder.build());
        }
        return null;
    }

}
