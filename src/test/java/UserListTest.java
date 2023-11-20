import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    private UserList userList;


    @BeforeEach
    void setUp() {
        userList = new UserList();
    }

    @Test
    void addUser_ShouldAddUser() {
        User user = new User("testUser", "testPassword");
        userList.addUser(user);

        assertTrue(userList.getUserData().containsKey("testUser"));
        assertEquals(user, userList.getUser("testUser"));
    }

    @Test
    void addUser_ShouldNotAddExistingUser() {
        User user1 = new User("testUser", "testPassword");
        User user2 = new User("testUser", "newPassword");

        userList.addUser(user1);
        userList.addUser(user2);


        assertTrue(userList.getUserData().containsKey("testUser"));
    }

    @Test
    void removeUser_ShouldRemoveUser() {
        User user = new User("testUser", "testPassword");
        userList.addUser(user);

        userList.removeUser(user);

        assertFalse(userList.getUserData().containsKey("testUser"));
        assertNull(userList.getUser("testUser"));
    }

    @Test
    public void isUserLoggedIn_shouldSayIfUserIsLoggedIn () {
        User user = new User("testUser", "testPassword");
        userList.addUser(user);
        UserAuthentication userAuthentication = new UserAuthentication(userList);
        userAuthentication.login("testUser", "testPassword");
        assertTrue(userList.isUserLoggedIn("testUser"));
    }

    @Test
    public void isEmpty_ShouldSayIfEmpty() {
        assertTrue(userList.isEmpty());
    }
    @Test
    public void authenticateUser_false() {  assertFalse(userList.authenticateUser("Test", "test"));
    }
    @Test
    public void setLoggedInStatus_setLoggedIn() {
        User user = new User("testUser", "testPassword");
        userList.addUser(user);
        userList.setLoggedInStatus("testUser", true);
        assertTrue(userList.isUserLoggedIn("testUser"));


    }

    @Test
    public void updateUserInfo_bothTests() {
        User user = new User("testUser", "testPassword");
        userList.addUser(user);
        userList.updateUserInfo("testUser", "Test Name", "1234567889", "Test Address");
        assertEquals("Test Name", user.getName());
        assertEquals("1234567889", user.getCreditCard());
        assertEquals("Test Address", user.getAddress());
       

    }
}
