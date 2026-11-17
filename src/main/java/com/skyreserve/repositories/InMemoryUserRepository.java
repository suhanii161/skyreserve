package com.skyreserve.repositories;

import com.skyreserve.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository {
    private final List<User> users = new ArrayList<>();

    public InMemoryUserRepository() {
        // Initialize with default mock data
        users.add(new User("customer", "password", "CUSTOMER", "Sarthak Jain"));
        users.add(new User("staff", "password", "STAFF", "Jane Staff"));
        users.add(new User("admin", "password", "ADMIN", "Admin User"));
        
        // Give customer some loyalty points to match mockups
        users.get(0).setLoyaltyPoints(8420);
    }

    public Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }
}
