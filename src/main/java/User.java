public class User {
    private String username;
    private String password;
    private boolean loggedIn;
    private String name;
    private String creditCard;
    private String Address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }




    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void displayUserInfo() {
        System.out.println("User Information for " + username);
        System.out.println("Name: " + name);
        System.out.println("Credit Card: " + creditCard);
        System.out.println("Address: " + Address);
    }


    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.loggedIn = false;

    }



}