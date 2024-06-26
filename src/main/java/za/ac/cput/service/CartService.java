package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart read(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public Cart update(Cart cart) {
        if (cartRepository.existsById(cart.getCartId())) {
            return cartRepository.save(cart);
        }
        return null;
    }

    public void delete(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    public Set<Cart> getAll() {
        return new HashSet<>(cartRepository.findAll());
    }
}
