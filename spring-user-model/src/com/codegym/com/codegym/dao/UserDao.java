package com.codegym.com.codegym.dao;

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
        u1.setAge(20);
        u1.setName("Hieu");
        u1.setAccount("hieu");
        u1.setEmail("hieu300695@gmail.com");
        u1.setPassword("123456");
        users.add(u2);

        User u3 = new User();
        u1.setAge(30);
        u1.setName("Tuan");
        u1.setAccount("tuan");
        u1.setEmail("tuan300695@gmail.com");
        u1.setPassword("123456");
        users.add(u3);
    }

    public static User checkLogin(Login login){
        for (User u: users ){
            if (u.getAccount().equals   (login.getAccount()) && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
