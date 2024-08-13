package za.ac.cput.facade;

import za.ac.cput.domain.*;

public interface CustomerFacade {
    Customer registerCustomer(Customer customer);
    Customer login(String username, String password);
//    Cart addToCart(Long customerId, Long productId, int quantity);
//    Cart getCart(Long customerId);
//    Order checkout(Long customerId, Address shippingAddress);//, Payment payment);
}
