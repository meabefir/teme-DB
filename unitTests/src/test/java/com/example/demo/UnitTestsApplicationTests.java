package com.example.demo;

import com.example.demo.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.Order;

@SpringBootTest
class UnitTestsApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private WishlistService wishlistService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	// spoiler, testele merg separat, nu merg toate testele daca dau test all, am incercat sa resetez baza de date cu functia de mai jos dar nu merge si nu am idee de ce
	@BeforeEach
	void resetDb() {
		userService.deleteAll();
		wishlistService.deleteAll();
		cartService.deleteAll();
		orderService.deleteAll();
		productService.deleteAll();
	}

}
