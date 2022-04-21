package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("getAll")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PostMapping("addProduct/{userId}")
    public void addProductToCart(@PathVariable Integer userId, @RequestBody Product product) {
        cartService.addProductToCart(userId, product);
    }

    @DeleteMapping("empty/{userId}")
    public void emptyCart(@PathVariable Integer userId) {
        cartService.emptyCart(userId);
    }
}
