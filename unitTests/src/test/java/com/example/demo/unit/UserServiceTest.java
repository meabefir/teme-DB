package com.example.demo.unit;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void whenGenerate3Users_ThenHave3UsersInDb() {
        User u1 = new User();
        u1.setName("user1");
        User u2 = new User();
        u2.setName("user2");
        User u3 = new User();
        u3.setName("user3");

        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);

        Assertions.assertEquals(3, userService.getAll().size());
//        User u1 = new User();
//        u1.setName("user1");
//        User u2 = new User();
//        u2.setName("user2");
//        User u3 = new User();
//        u3.setName("user3");
//
//        userService.createUser(u1);
//        userService.createUser(u2);
//        userService.createUser(u3);
//
//        User u11 = userService.getById(u1.getId());
//        User u22 = userService.getById(u2.getId());
//        User u33 = userService.getById(u3.getId());
//
//        Assertions.assertEquals(u1.getName(), u11.getName());
//        Assertions.assertEquals(u2.getName(), u22.getName());
//        Assertions.assertEquals(u3.getName(), u33.getName());
    }
}
