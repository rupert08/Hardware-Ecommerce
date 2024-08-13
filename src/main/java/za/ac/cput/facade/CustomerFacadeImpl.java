package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.*;
import za.ac.cput.service.*;

import java.util.Optional;

@Service
public class CustomerFacadeImpl implements CustomerFacade {
    private final CustomerService customerService;
    //private final CartService cartService;
    //private final ProductService productService;
    //private final OrderService orderService;
    //private final PaymentService paymentService;

//    @Autowired
//    public CustomerFacadeImpl(CustomerService customerService/*,CartService cartService*/, ProductService productService,
//                              OrderService orderService/*, PaymentService paymentService*/) {
//        this.customerService = customerService;
//       // this.cartService = cartService;
//        this.productService = productService;
//        this.orderService = orderService;
//        //this.paymentService = paymentService;
//    }
    @Autowired
    public CustomerFacadeImpl(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Override
    public Customer registerCustomer(Customer customer) {
        return customerService.create(customer);
    }

    @Override
    public Customer login(String username, String password) {
        return customerService.findByUsernameAndPassword(username, password);
    }

//    @Override
//    public Cart addToCart(Long customerId, Long productId, int quantity) {
//        Optional<Cart> cartOptional = cartService.findByCustomerId(customerId);
//        Cart cart = cartOptional.orElseGet(() -> cartService.create(new Cart(customerId)));
//
//        Product product = productService.read(productId);
//        CartItem cartItem = new CartItem(product, quantity, product.getPrice() * quantity);
//        cart.addCartItem(cartItem);
//
//       return /*cartService.update(cart)*/null;
//    }
//
//    @Override
//    public Cart getCart(Long customerId) {
//        return /*cartService.findByCustomerId(customerId).orElse*/(null);
//    }

//    @Override
//    public Order checkout(Long customerId, Address shippingAddress/*, Payment payment*/) {
       // Cart cart = cartService.findByCustomerId(customerId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
       // Order order = new Order(/*cart,*/ shippingAddress/*, payment*/);
       // Order createdOrder = orderService.create(order);

//        payment.setOrder(createdOrder);
//        paymentService.create(payment);

//       return null; //createdOrder;
//    }
}
