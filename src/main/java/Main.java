import Products.ConcreteProduct;
import Products.Product;
import Products.ProductCatalog;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) { // currently testing login and authentication
        UserList userList = new UserList();
        ProductCatalog productCatalog = new ProductCatalog();
        List<Product> allProducts = productCatalog.getAllProducts();
        UserAuthentication userAuthentication = new UserAuthentication(userList);
        boolean exit = false;
        Scanner scan1 = new Scanner(System.in);
        ItemList itemList = null;
        ShoppingCart shoppingCart = null;

        System.out.println("Welcome to Atif's Penguin Emporium! Here we sell ONLY the finest, \n" +
                "lovingly hand-crafted ceramic ornamental Penguins in a variety of great sizes! \nPlease select an option to get started:\n");

        do {
            try {
                System.out.println("\n===========================================");
                System.out.println(" 1. Sign in\n 2. Sign up for an account\n 3. View Product catalog!\n 4. View cart\n 5. Checkout Items in Cart\n 6. Update account information \n 7. sign out\n 8. View secret stuff (for testing ONLY!)\n 9. Leave the shop.");
                System.out.println("===========================================");

                if (scan1.hasNextInt()) {
                    int choice = scan1.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Please enter your username");
                            String username = scan1.next();
                            System.out.println("Please enter your password");
                            String password = scan1.next();
                            userAuthentication.login(username, password);
                            // log

                            break;
                        case 2:
                            System.out.println("Please enter your username");
                            String username1 = scan1.next();
                            System.out.println("Please enter your password");
                            String password1 = scan1.next();
                            userList.addUser(new User(username1, password1));
                            itemList = new ItemList(username1);

                            // log
                            break;
                        case 3:
                            System.out.println("Here's the products!");
                            for (Product product : allProducts) {
                                System.out.println("Name: " + product.getName());
                                System.out.printf("Price: $%.2f\n", product.getPrice());
                                System.out.println("----------------------");
                                // needs add to cart functionality
                            }
                            System.out.println("What would you like to do?");
                            int i = 0;
                            for (Product product : allProducts) {
                                i++;
                                System.out.println(i + ". Add " + product.getName() + " to cart");
                            }
                            i = i + 1;
                            System.out.println(i + ". Return to main menu");
                            int catChoice = scan1.nextInt();
                            if (catChoice == i) {
                                break;
                            } else {
                                if (userAuthentication.isUserLoggedIn()) {
                                    String username2 = userAuthentication.getLoggedInUser().getUsername();

                                    switch (catChoice) {
                                        case 1:
                                            System.out.println("How many " + allProducts.get(0).getName() + "s do you want to add?");
                                            int quantityToAdd = scan1.nextInt();

                                            // Update the quantity of the product
                                            Product selectedProduct = allProducts.get(0);
                                            selectedProduct.setQuantity(quantityToAdd);

                                            System.out.println(quantityToAdd + " " + selectedProduct.getName() + "(s) added to the cart!");
                                            //logs
                                            assert itemList != null;
                                            itemList.addItem(selectedProduct);
                                            shoppingCart = ShoppingCart.getInstance(); // Ensure the instance is created
                                            shoppingCart.setCurrentUser(username2);
                                            shoppingCart.addItem(username2, selectedProduct);
                                            break;
                                        case 2:
                                            System.out.println("How many " + allProducts.get(1).getName() + "s do you want to add?");
                                            int quantityToAdd2 = scan1.nextInt();

                                            // Update the quantity of the product
                                            Product selectedProduct2 = allProducts.get(1);
                                            selectedProduct2.setQuantity(quantityToAdd2);

                                            System.out.println(quantityToAdd2 + " " + selectedProduct2.getName() + "(s) added to the cart!");
                                            // logs
                                            assert itemList != null;
                                            itemList.addItem(selectedProduct2);
                                            shoppingCart = ShoppingCart.getInstance(); // Ensure the instance is created
                                            shoppingCart.setCurrentUser(username2);
                                            shoppingCart.addItem(username2, selectedProduct2);
                                            break;
                                        default:
                                            System.out.println("Please enter an option listed above");
                                            break;
                                    }
                                } else {
                                    System.out.println("You need to log in or sign up before adding items to your cart.");
                                }
                            }

                            break;
                        case 4:

                            if (itemList != null) {
                                System.out.println("Here is Your cart!");
                                if (userAuthentication.isUserLoggedIn()) {
                                    String username2 = userAuthentication.getLoggedInUser().getUsername();
                                    displayCart(username2);
                                }

                            } else {
                                System.out.println("You need to log in or sign up before viewing your cart.");
                            }
                            break;
                        case 5:
                            if (itemList == null || !userAuthentication.isUserLoggedIn()) {
                                System.out.println("There's nothing your cart! Try adding items or signing in!");
                                break;
                            } else {


                            }
                        case 6:
                            if (userAuthentication.isUserLoggedIn()) {
                                String username2 = userAuthentication.getLoggedInUser().getUsername();
                                System.out.println("Here's your current account information: ");
                                userList.displayUserDetails(username2);
                                System.out.println("would you like to add your card and address? Press 1 for yes, or 2 for no");
                                int choiceAccount = scan1.nextInt();
                                scan1.nextLine();
                                switch (choiceAccount) {
                                    case 1:
                                        System.out.println("Please enter your name with a space in the middle like Penguin Joe");
                                        String name = scan1.nextLine();
                                        System.out.println("Please enter the CC info, with dashes, like 1234-5678-9012-3456");
                                        String ccInfo = scan1.nextLine();
                                        System.out.println("Please enter your address, like 123 Penguin avenue");
                                        String address = scan1.nextLine();
                                        userList.updateUserInfo(username2, name, ccInfo, address);
                                        System.out.println("here is your updated information");
                                        userList.displayUserDetails(username2);
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Please enter an option listed above");
                                }
                            } else {
                                System.out.println("You're not signed in. Why not try signing in?");
                            }
                            break;
                        case 7:
                            userAuthentication.logout();
                            System.out.println("See ya!");
                            // logs
                            break;
                        case 8:
                            System.out.println("Hey that's a secret!");
                            userList.displayAllUsers();
                            // user list
                            break;
                        case 9:
                            System.out.println("Okay bye!");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid entry detected. Please enter only a number listed above, thanks.\n");
                            break;
                    }
                } else {
                    System.out.println("Invalid entry detected. Please enter only a number between 1-6, thanks.\n");
                    scan1.next();
                }
            } catch (InputMismatchException e) { //checks for incorrect data types to avoid crashing
                System.out.println("incorrect data type entered");
                scan1.next();
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
                scan1.next();
            }
        }
        while (!exit);
        scan1.close();


        // Print information about each product

    }
        private static void displayItems (ItemList itemList){
            System.out.println("Items for " + itemList.getUsername() + ": " + itemList.getItems());
        }

        private static void displayCart (String username){
            ShoppingCart.getInstance().displayProducts(username);
        }
    }












