import java.util.HashMap;

public class UserAuthentication {
    private User loggedInUser;
    private UserList userList;

    public UserAuthentication(UserList userList) {
        this.loggedInUser = null;
        this.userList = userList;
    }

    public boolean login(String username, String password) {
        logout();
        boolean loggedIn = userList.authenticateUser(username, password);
        if (loggedIn) {
            User user = userList.getUser(username);
            if (user.isLoggedIn()) {
                System.out.println("User " + username + " is already logged in.");
                return false;
            }

            user.setLoggedIn(true);
            loggedInUser = user;

            System.out.println(username + " logged in successfully! Welcome back!");
            return true;
        } else {
            System.out.println("Username not found. Would you like to sign up and create an account?");
            return false;
        }
    }


    public void logout() {
        if (loggedInUser != null) {
            loggedInUser.setLoggedIn(false);
            System.out.println(loggedInUser.getUsername() + " logged out successfully! Please come again!");
            loggedInUser = null;
        } else {
            System.out.println("No user currently logged in.");
        }
    }
}
