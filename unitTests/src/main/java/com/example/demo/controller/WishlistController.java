package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.Wishlist;
import com.example.demo.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("getAll")
    public List<Wishlist> getAll() {
        return wishlistService.getAll();
    }

    @PostMapping("addProduct/{userId}")
    public void addProductToWishlist(@PathVariable Integer userId, @RequestBody Product product) {
        wishlistService.addProductToWishlist(userId, product);
    }

    @DeleteMapping("empty/{userId}")
    public void emptyWishlist(@PathVariable Integer userId) {
        wishlistService.emptyWishlist(userId);
    }
}
