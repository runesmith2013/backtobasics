package com.rob.java.b2b;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTest {

    class User {

        public void setFirstName(String newName) {
        }
    }

    private static Map<String, User> usersByName = new HashMap<>();

    @Test
    public static Optional<User> findUserByName(String name) {
        User user = usersByName.get(name);
        Optional<User> opt = Optional.ofNullable(user);

        return opt;
    }
    
    public static void changeUser(String old, String newName) {
         findUserByName(old).ifPresent( user -> user.setFirstName(newName));
    }
    
}
