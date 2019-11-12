package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User>users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("Lam");
        u1.setAccount("lam");
        u1.setEmail("lam300695@gmail.com");
        u1.setPassword("123456");
        users.add(u1);

        User u2 = new User();
        u2.setAge(20);
        u2.setName("Hieu");
        u2.setAccount("hieu");
        u2.setEmail("hieu300695@gmail.com");
        u2.setPassword("123456");
        users.add(u2);

        User u3 = new User();
        u3.setAge(30);
        u3.setName("Tuan");
        u3.setAccount("tuan");
        u3.setEmail("tuan300695@gmail.com");
        u3.setPassword("123456");
        users.add(u3);
    }

    public static User checkLogin(Login login){
        for (User u: users){
            if (u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
