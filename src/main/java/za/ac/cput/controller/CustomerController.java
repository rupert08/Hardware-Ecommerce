// CustomerController.java
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:5116", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Customer obj) {
        Customer login = CustomerFactory.createCustomer(obj.getUsername(), obj.getPassword());

        if (login == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(customerService.findByUsernameAndPassword(login.getUsername(), login.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer obj) {
        Customer buildObj = CustomerFactory.createCustomer(obj.getUsername(), obj.getPassword(), obj.getFirstName(), obj.getLastName(), obj.getContact());
        Customer exists = customerService.read(obj.getUserId());
        if (buildObj == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        if (exists != null) {
            System.out.println(exists);
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerService.create(buildObj));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Customer> read(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.read(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustAddress(@RequestBody Customer obj) {
        Customer buildObj = CustomerFactory.createCustomer(obj.getUsername(), obj.getPassword(), obj.getFirstName(), obj.getLastName(), obj.getContact());
        Customer exists = customerService.read(obj.getUserId());

        if (buildObj == null) {
            System.out.println(1);
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }

        if (exists != null) {
            Customer updated = customerService.update(buildObj);
            System.out.println(updated.getAddress());
            return ResponseEntity.status(HttpStatus.OK).body(customerService.read(updated.getUserId()));
        }
        System.out.println(exists);
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
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