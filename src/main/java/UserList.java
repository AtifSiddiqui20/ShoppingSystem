import java.util.*;

public class UserList { // this class manages the dicionary for users
    private Map<String, User> userData; // this map will store the users' credentials

    public Map<String, User> getUserData() {
        return userData;
    }

    public UserList() {
        this.userData = new HashMap<>();
    }

    public void addUser(User user) { // logs needed
        String username = user.getUsername();
        if (userData.containsKey(username)) {
            System.out.println("User " + username + " already has an account with us, try logging in instead?");

        } else {
            userData.put(username, user);
            System.out.println("You have successfully signed up! Redirecting back to the main page...");
        }

    }

    public void removeUser(User user) { // logs needed
        String username = user.getUsername();
        if (userData.containsKey(username)) {
            System.out.println("User " + username + " has been removed, we're sad to see you go!");
            user.setLoggedIn(false);
            userData.remove(username);

        } else {
            System.out.println("Hm... that username isn't in our system. Why not try signing up :)?");
        }

    }

    public boolean authenticateUser(String username, String password) {
        if (userData.containsKey(username)) {
            User user = userData.get(username);
            if (user.getPassword().equals(password)) {
                System.out.println("User " + username + " authenticated successfully.");

                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }


    public User getUser(String username) {
        return userData.get(username);
    }

    public void displayAllUsers() {
        System.out.println("List of all users:");

        for (Map.Entry<String, User> entry : userData.entrySet()) {
            User user = entry.getValue();
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }
    }
}


