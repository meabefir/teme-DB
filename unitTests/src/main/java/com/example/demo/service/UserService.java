package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.User;
import com.example.demo.model.Wishlist;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final WishlistRepository wishlistRepository;

    private final CartService cartService;

    public List<User> getAll() {
        var users = userRepository.findAll();
        Collections.sort(users);
        return users;
    }

    public void createUser(User user) {
        userRepository.save(user);

        Cart userCart = new Cart();
        userCart.setUser(user);
        cartRepository.save(userCart);

        Wishlist userWishlist = new Wishlist();
        userWishlist.setUser(user);
        wishlistRepository.save(userWishlist);

        user.setCart(userCart);
        user.setWishlist(userWishlist);

        userRepository.save(user);
    }

    public User getById(Integer id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            user.getCart().setUser(null);
            user.getWishlist().setUser(null);
            for (var order: user.getOrders()) {
                order.setUser(null);
            }

            userRepository.delete(user);
        }
    }

    public void deleteAll() {
//        List<User> toDelete = userRepository.findAll();
//        List<Integer> ids = toDelete.stream().map(user -> user.getId()).collect(Collectors.toList());
//        for (Integer id: ids) {
//            deleteUser(id);
//        }
        userRepository.deleteAll();
    }
}
