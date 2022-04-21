package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Wishlist;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final WishlistRepository wishlistRepository;
    private final OrderRepository orderRepository;

    public void removeProduct(Integer productId) {
        Optional<Product> prodToDeleteO = productRepository.findById(productId);
        if (prodToDeleteO.isPresent()) {
            Product prodToDelete = prodToDeleteO.get();

            Cart prodCart = prodToDelete.getCart();
            Wishlist prodWishlist = prodToDelete.getWishlist();
            Order prodOrder = prodToDelete.getOrder();

            if (prodCart != null) prodCart.getProducts().remove(prodToDelete);
            if (prodWishlist != null) prodWishlist.getProducts().remove(prodToDelete);
            if (prodOrder != null) prodOrder.getProducts().remove(prodToDelete);

            if (prodCart != null) cartRepository.save(prodCart);
            if (prodWishlist != null) wishlistRepository.save(prodWishlist);
            if (prodOrder != null) orderRepository.save(prodOrder);

            productRepository.delete(prodToDelete);
        }
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public Product getById(Integer id) {
        return productRepository.getById(id);
    }
}
