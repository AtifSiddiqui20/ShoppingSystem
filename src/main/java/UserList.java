import java.util.*;

public class UserList { // this class manages the dicionary for users
    private final Map<String, User> userData; // this map will store the users' credentials

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
            Logger.log(username +" signed in successfully");
        }

    }

    public void removeUser(User user) { // logs needed
        String username = user.getUsername();
        if (userData.containsKey(username)) {
            System.out.println("User " + username + " has been removed, we're sad to see you go!");
            Logger.log(username +"'s removed successfully.");
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
                Logger.log(username +"'s was authenticated successfully.");

                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public boolean isUserLoggedIn(String username) {
        User user = getUser(username);
        Logger.log(username +" was checked if they were logged in or not");
        return user != null && user.isLoggedIn();
    }

    public boolean isEmpty() {
        return userData.isEmpty();
    }

    public void setLoggedInStatus(String username, boolean loggedIn) {
        User user = getUser(username);
        if (user != null) {
            user.setLoggedIn(loggedIn);
        } else {
            System.out.println("User with username " + username + " not found.");
        }
    }
    public User getUser(String username) {
        return userData.get(username);
    }

    public void updateUserInfo(String username, String name, String creditCard, String address) {
        if (userData.containsKey(username)) {
            User user = userData.get(username);
            user.setName(name);
            user.setCreditCard(creditCard);
            user.setAddress(address);
            System.out.println("User information updated successfully.");
            Logger.log(username +"'s information updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayUserDetails(String username) {
        if (userData.containsKey(username)) {
            User user = userData.get(username);
            user.displayUserInfo();
            Logger.log(username +"'s information shown successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
    public void displayAllUsers() {
        if (isEmpty()) {
            System.out.println("No users in the system.");
        } else {
            System.out.println("List of all users:");
            for (Map.Entry<String, User> entry : userData.entrySet()) {
                User user = entry.getValue();
                Logger.log("All users were displayed to User");
                System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
            }
        }
    }
}


