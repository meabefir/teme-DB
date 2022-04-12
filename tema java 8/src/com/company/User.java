package com.company;

import java.net.Inet4Address;
import java.util.Random;

public class User implements Comparable<User> {
    private Long id;
    private String name;
    private Integer age;
    private static Long currentId;

    static {
        currentId = 0L;
    }

    {
        currentId += 1;
    }

    public User() {
        id = currentId;
    }

    public User(String name, Integer age) {
        id = currentId;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static User createUser() {
        User newUser = new User();
        Random r = new Random();
        String[] names = {"gigel", "costel", "marinel", "petrinel"};
        newUser.setName(names[r.nextInt(names.length)]);
        newUser.setAge(r.nextInt(100));
        return newUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("used");
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        User user = (User)o;
        return (this.getAge().equals(user.getAge()) && this.getName().equals(user.getName()));
    }
}
