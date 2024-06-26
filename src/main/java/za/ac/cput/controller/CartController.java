package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.service.CartService;

import java.util.Set;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @GetMapping("/read/{cartId}")
    public Cart read(@PathVariable Long cartId) {
        return cartService.read(cartId);
    }

    @PutMapping("/update")
    public Cart update(@RequestBody Cart cart) {
        return cartService.update(cart);
    }

    @DeleteMapping("/delete/{cartId}")
    public void delete(@PathVariable Long cartId) {
        cartService.delete(cartId);
    }

    @GetMapping("/getAll")
    public Set<Cart> getAll() {
        return cartService.getAll();
    }
}
