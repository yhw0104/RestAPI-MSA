package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "yoon", new Date()));
        users.add(new User(2, "kwon", new Date()));
        users.add(new User(3, "cho", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for (User user : users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if(user.getId() == null){
            user.setId(++userCount);
        }


        users.add(user);

        return user;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    public User editUser(int id, User user) {
        User findUser = findOne(id);
        findUser.setName(user.getName());
        findUser.setJoinDate(user.getJoinDate());
        return findUser;
    }
}
