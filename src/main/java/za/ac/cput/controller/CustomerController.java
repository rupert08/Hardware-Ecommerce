    package za.ac.cput.controller;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import za.ac.cput.domain.Customer;
    import za.ac.cput.factory.CustomerFactory;
    import za.ac.cput.service.CustomerService;

    import java.util.Set;

    @RestController
    @RequestMapping("/customer")
    public class CustomerController {
        @Autowired
        private CustomerService customerService;

        @PostMapping("/create")
        public Customer create(@RequestBody Customer customer) {
            // Assuming the customer is created with factory method before passing to the service
            Customer createdCustomer = CustomerFactory.createCustomer2(
                    customer.getUsername(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getContact(),
                    customer.getPassword(),
                    customer.getRole(),
                    customer.getAddress()
            );

            if (createdCustomer == null) {
                throw new IllegalArgumentException("Invalid customer data, please make sure to add all the required data");
            }

            return customerService.create(createdCustomer);
        }
        @GetMapping("/read/{id}")
        public Customer read(@PathVariable Long id) {
            return customerService.read(id);
        }

        @PutMapping("/update")
        public Customer update(@RequestBody Customer customer) {

            return customerService.partialUpdate(customer);
        }

        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable Long id) {
            customerService.delete(id);
        }

        @GetMapping("/getAll")
        public Set<Customer> getAll() {
            return customerService.getAll();
        }
    }
