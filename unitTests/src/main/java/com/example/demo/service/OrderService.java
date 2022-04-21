package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public void placeOrder(Integer userId) {
        Optional<User> opt = userRepository.findById(userId);
        if (opt.isPresent()) {
            User user = opt.get();

            // trb sa elimin comenzile din cos si sa le pun intr-un order nou
            Order newOrder = new Order();
            newOrder.setUser(user);
            newOrder.setDate(new Date());
            orderRepository.save(newOrder);

//            return;
            user.addOrder(newOrder);
            userRepository.save(user);

            Cart userCart = user.getCart();

            // le salvez intr-o lista locala si le sterg din user cart
            List<Integer> productIdsToOrder = userCart.getProducts().stream().map(prod -> prod.getId()).collect(Collectors.toList());
            userCart.setProducts(new ArrayList<Product>());
            cartRepository.save(userCart);

            orderRepository.save(newOrder);
            for (var productId: productIdsToOrder) {
                var prodOpt = productRepository.findById(productId);
                if (prodOpt.isEmpty()) continue;
                Product prod = prodOpt.get();
                prod.setCart(null);
                prod.setOrder(newOrder);
                productRepository.save(prod);
                newOrder.getProducts().add(prod);
            }

            orderRepository.save(newOrder);
        }
    }

    public List<Order> orderHistory(Integer userId) {
        return orderRepository.findAllByUser_IdOrderByDateDesc(userId);
//        List<Order> orders = orderRepository.getAllByUser_Id(userId);
//        Collections.sort(orders);
//        return orders;
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
