package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.Wishlist;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final WishlistRepository wishlistRepository;
    private final OrderRepository orderRepository;

    private final ProductService productService;

    public List<Wishlist> getAll() {
        return wishlistRepository.findAll();
//        return (List<Cart>) cartRepository.findAll();
    }

    public void addProductToWishlist(Integer userId, Product product) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            return;
        }
        User user = userOpt.get();
        Wishlist userWishlist = user.getWishlist();

        product.setWishlist(userWishlist);
        productRepository.save(product);

        userWishlist.addProduct(product);
        wishlistRepository.save(userWishlist);
    }

    public void emptyWishlist(Integer userId) {
        Optional<User> opt = userRepository.findById(userId);
        if (opt.isPresent()) {
            User user = opt.get();
            Wishlist wishlist = user.getWishlist();
            List<Integer> productIdsToDelete = wishlist.getProducts().stream().map(product -> product.getId()).collect(Collectors.toList());
            for (var id: productIdsToDelete) {
                productService.removeProduct(id);
            }
            wishlistRepository.save(wishlist);
        }
    }

    public void deleteAll() {
        wishlistRepository.deleteAll();
    }
}
