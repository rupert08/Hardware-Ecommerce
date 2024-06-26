package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItem;
import za.ac.cput.service.CartItemService;

import java.util.Set;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItem cartItem) {
        return cartItemService.create(cartItem);
    }

    @GetMapping("/read/{cartItemId}")
    public CartItem read(@PathVariable Long cartItemId) {
        return cartItemService.read(cartItemId);
    }

    @PutMapping("/update")
    public CartItem update(@RequestBody CartItem cartItem) {
        return cartItemService.update(cartItem);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public void delete(@PathVariable Long cartItemId) {
        cartItemService.delete(cartItemId);
    }

    @GetMapping("/getAll")
    public Set<CartItem> getAll() {
        return cartItemService.getAll();
    }
}
