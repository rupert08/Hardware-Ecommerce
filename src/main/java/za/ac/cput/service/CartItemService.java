package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.CartItemRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem create(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem read(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElse(null);
    }

    public CartItem update(CartItem cartItem) {
        if (cartItemRepository.existsById(cartItem.getCartItemID())) {
            return cartItemRepository.save(cartItem);
        }
        return null;
    }

    public void delete(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public Set<CartItem> getAll() {
        return new HashSet<>(cartItemRepository.findAll());
    }
}
