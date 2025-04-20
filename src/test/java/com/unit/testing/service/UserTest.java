package com.unit.testing.service;

import com.unit.testing.model.UserEntity;
import com.unit.testing.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    private UserEntity savedUser;

    @BeforeEach
    void setup() {
        UserEntity user = new UserEntity();
        user.setUserFullName("Mesut Ozil");
        user.setEmail("Ozil@gmail.com");
        user.setAddress("123 Main st");

        savedUser = userRepository.save(user);
        System.out.println("Saved user : " + savedUser);

    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void testCreateUser() {
        assertNotNull(savedUser.getUserId());
        assertNotNull(savedUser);
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void testGetUserById() {
        UserEntity foundUser = userRepository.findById(savedUser.getUserId()).orElse(null);

        assertNotNull(foundUser);
        assertEquals(savedUser.getUserFullName(), foundUser.getUserFullName());
        assertEquals(savedUser.getEmail(), foundUser.getEmail());
        assertEquals(savedUser.getAddress(), foundUser.getAddress());
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void testUpdateUser() {
        savedUser.setUserFullName("Bukayo Saka");
        savedUser.setEmail("saka@gmail.com");

        UserEntity updatedUser = userRepository.save(savedUser);

        assertNotNull(savedUser);
        assertEquals("Bukayo Saka", savedUser.getUserFullName());
        assertEquals("saka@gmail.com", savedUser.getEmail());
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void testDeleteUser() {
        userRepository.delete(savedUser);

        UserEntity deleteUser = userRepository.findById(savedUser.getUserId()).orElse(null);

        assertNull(deleteUser);
    }
}
