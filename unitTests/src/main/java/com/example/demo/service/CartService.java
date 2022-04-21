package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final WishlistRepository wishlistRepository;
    private final OrderRepository orderRepository;

    private final ProductService productService;

    public Cart getCartById(Integer id) {
        return cartRepository.getById(id);
    }

    public List<Cart> getAll() {
        List<Cart> carts = cartRepository.findAll();
        Collections.sort(carts);
        return carts;
//        return (List<Cart>) cartRepository.findAll();
    }

    public void addProductToCart(Integer userId, Product product) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            return;
        }
        User user = userOpt.get();
        Cart userCart = user.getCart();

        product.setCart(userCart);
        productRepository.save(product);

        userCart.addProduct(product);
        cartRepository.save(userCart);
    }

    public void emptyCart(Integer userId) {
        Optional<User> opt = userRepository.findById(userId);
        if (opt.isPresent()) {
            User user = opt.get();
            Cart cart = user.getCart();
            List<Integer> productIdsToDelete = cart.getProducts().stream().map(product -> product.getId()).collect(Collectors.toList());
            for (var id: productIdsToDelete) {
                productService.removeProduct(id);
            }
            cartRepository.save(cart);
        }
    }

    public void deleteAll() {
        cartRepository.deleteAll();
    }
}
