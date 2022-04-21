package com.example.demo.unit;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.Wishlist;
import com.example.demo.service.CartService;
import com.example.demo.service.UserService;
import com.example.demo.service.WishlistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WishlistServiceTest {
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private UserService userService;

    @Test
    public void whenGenerateUserAndAddProductToWishlist_ThenHave1ProductInWishlist() {
        User user = new User();
        user.setName("test");
        userService.createUser(user);

        Product newProduct = new Product();
        newProduct.setName("pizza");
        newProduct.setPrice(13.99);
        newProduct.setQuantity(3);

        wishlistService.addProductToWishlist(user.getId(), newProduct);

        List<Wishlist> wishlists = wishlistService.getAll();
        Assertions.assertEquals(1, wishlists.size());

        Wishlist wishlist = wishlists.get(0);
        Assertions.assertEquals(1, wishlist.getProducts().size());

        Product product = wishlist.getProducts().get(0);
        Assertions.assertEquals("pizza", product.getName());
        Assertions.assertEquals(13.99, product.getPrice());
        Assertions.assertEquals(3, product.getQuantity());
    }
}
