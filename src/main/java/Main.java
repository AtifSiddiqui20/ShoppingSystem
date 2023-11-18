public class Main {

    public static void main(String[] args) { // currently testing login and authentication
        UserList userList = new UserList();


        User johnDoe = new User("john_doe", "password123");
        User janeSmith = new User("jane_smith", "pass456");

        userList.addUser(johnDoe);
        userList.addUser(janeSmith);

        userList.displayAllUsers();
        UserAuthentication userAuthentication = new UserAuthentication(userList);
        userAuthentication.login("john_doe", "password123");
        userList.addUser(janeSmith);
        userAuthentication.logout();
        userList.removeUser(johnDoe);
        userList.displayAllUsers();

    }

}
