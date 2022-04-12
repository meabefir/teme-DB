package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<User> usersList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            usersList.add(User.createUser());
        }
        usersList.add(new User("test", 2));
        usersList.add(new User("test", 2));
        System.out.println(usersList);

//        doar filtrarea cu sub 18
//        System.out.println(usersList.stream()
//                .filter(user -> user.getAge() < 18)
//                .collect(Collectors.toList()));

//        dublam varsta
//        System.out.println(usersList.stream()
//                .filter(user -> user.getAge() < 18)
//                .map(user -> {user.setAge(user.getAge()*2); return user;})
//                .collect(Collectors.toList()));

//        print last element
//        System.out.println(usersList.stream()
//                .filter(user -> user.getAge() < 18)
//                .map(user -> {user.setAge(user.getAge()*2); return user;})
//                .reduce((first, second) -> second)
//                .orElse(null));

//        max age
//        System.out.println(usersList.stream()
//                .max((u1, u2) -> u1.getAge().compareTo(u2.getAge()))
//                .orElse(null));

//        min age
//        System.out.println(usersList.stream()
//                .min((u1, u2) -> u1.getAge().compareTo(u2.getAge()))
//                .orElse(null));

//        remove duplicates
        System.out.println(usersList.stream()
                .distinct()
                .collect(Collectors.toList()).size());

//        System.out.println(usersList.stream()
//                .filter(u -> u.getAge() > 30)
//                .map(u -> {u.setName(u.getName().toUpperCase(Locale.ROOT)); return u;})
//                .sorted((u1, u2) -> -u1.getAge().compareTo(u2.getAge()))
//                .collect(Collectors.toList()));
    }
}
