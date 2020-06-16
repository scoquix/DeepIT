package com.scoquix.deepIT.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthUserDTOTest {

    private final Logger logger = LoggerFactory.getLogger(AuthUserDTOTest.class);
    private AuthUserDTO authUserDTO;
    private AuthUserDTO fullAuthUserDTO;
    private List<String> roles;

    @BeforeEach
    void setUp() {
        authUserDTO = new AuthUserDTO();
        roles = new ArrayList<>();
        roles.add("USER");
        fullAuthUserDTO = new AuthUserDTO("X", new char[]{'Y'}, roles);
        logger.info("Before each");
    }

    @AfterEach
    void tearDown() {
        logger.info("After each");
    }

    @Test
    void getRoles() {
        assertNull(authUserDTO.getRoles());
        assertEquals(roles, fullAuthUserDTO.getRoles());
    }

    @Test
    void setRoles() {
        authUserDTO.setRoles(roles);
        assertEquals(roles, authUserDTO.getRoles());
    }

    @Test
    void getUsername() {
        assertNull(authUserDTO.getUsername());
        assertEquals("X", fullAuthUserDTO.getUsername());
    }

    @Test
    void setUsername() {
        fullAuthUserDTO.setUsername("Andzia");
        assertEquals("Andzia", fullAuthUserDTO.getUsername());
    }

    @Test
    void getPassword() {
        assertNull(authUserDTO.getPassword());
        assertArrayEquals(new char[]{'Y'}, fullAuthUserDTO.getPassword());
    }

    @Test
    void setPassword() {
        authUserDTO.setPassword(new char[]{'P'});
        assertArrayEquals(new char[]{'P'}, authUserDTO.getPassword());
    }

    @Test
    void testToString() {
        String toStr = "AuthUserDTO{" +
                "username='" + null + '\'' +
                ", password=" + null +
                ", roles=" + null +
                '}';
        assertEquals(toStr, authUserDTO.toString());
    }
}