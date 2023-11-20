import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testUser", "testPassword");
        user.setLoggedIn(true);
        user.setName("Penguin Joe");
        user.setCreditCard("1234-5678-9012-3456");
        user.setAddress("123 Penguin Avenue");
    }

    @Test
    void getName_ShouldReturnCorrectName() {
        assertEquals("Penguin Joe", user.getName());
    }

    @Test
    void getCreditCard_ShouldReturnCorrectCreditCard() {
        assertEquals("1234-5678-9012-3456", user.getCreditCard());
    }

    @Test
    void getAddress_ShouldReturnCorrectAddress() {
        assertEquals("123 Penguin Avenue", user.getAddress());
    }

    @Test
    void isLoggedIn_ShouldReturnTrue() {
        assertTrue(user.isLoggedIn());
    }

    @Test
    void getPassword_ShouldReturnCorrectPassword() {
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void getUsername_ShouldReturnCorrectUsername() {
        assertEquals("testUser", user.getUsername());
    }


        }


