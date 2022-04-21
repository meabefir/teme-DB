package com.example.demo.unit;

import com.example.demo.model.Cart;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @Test
    public void whenGenerateUserAndAddToCartAndPlaceOrder_ThenHaveOrderInOrderHistory() {
        User user = new User();
        user.setName("test");
        userService.createUser(user);

        Product newProduct = new Product();
        newProduct.setName("pizza");
        newProduct.setPrice(13.99);
        newProduct.setQuantity(3);

        cartService.addProductToCart(user.getId(), newProduct);

        orderService.placeOrder(user.getId());

        List<Cart> carts = cartService.getAll();
        Assertions.assertEquals(1, carts.size());

        Cart cart = carts.get(0);
        // cart should have no products
        Assertions.assertEquals(0, cart.getProducts().size());

        // order history for user should have 1 order and 1 product
        List<Order> orders = orderService.orderHistory(user.getId());
        Assertions.assertEquals(1, orders.size());
        Assertions.assertEquals(1, orders.get(0).getProducts().size());

        Product product = orders.get(0).getProducts().get(0);
        Assertions.assertEquals("pizza", product.getName());
        Assertions.assertEquals(13.99, product.getPrice());
        Assertions.assertEquals(3, product.getQuantity());
    }
}
