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
                System.out.println(" 1. Sign in\n 2. Sign up for an account\n 3. View Product catalog!\n 4. View cart\n 5. Checkout Items in Cart\n 6. Update account information \n 7. Sign out\n 8. View secret stuff (for testing ONLY!)\n 9. Leave the shop.");
                System.out.println("===========================================");

                if (scan1.hasNextInt()) {
                    int choice = scan1.nextInt();
                    switch (choice) {
                        case 1:
                            if (userAuthentication.isUserLoggedIn()) {
                                System.out.println("Someone else is already logged in, would you like to log them out? 1 for yes and 2 for no.");
                                int logout = scan1.nextInt();
                                if (logout == 1) {
                                    System.out.println("Please enter your username");
                                    String username = scan1.next();
                                    System.out.println("Please enter your password");
                                    String password = scan1.next();
                                    userAuthentication.login(username, password);
                                    System.out.println("Returning to menu...");
                                }
                            } else {
                                System.out.println("Please enter your username");
                                String username = scan1.next();
                                System.out.println("Please enter your password");
                                String password = scan1.next();
                                userAuthentication.login(username, password);
                                System.out.println("Returning to menu...");
                                break;
                            }
                            break;
                        case 2:
                            System.out.println("Please enter your username");
                            String username1 = scan1.next();
                            System.out.println("Please enter your password");
                            String password1 = scan1.next();
                            userList.addUser(new User(username1, password1));
                            userAuthentication.login(username1, password1);
                            itemList = new ItemList(username1);
                            System.out.println("Returning to menu...");

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
                                System.out.println("Returning to menu...");
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
                                            System.out.println("Returning to menu...");
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
                                            System.out.println("Returning to menu...");
                                            break;
                                        case 3:
                                            System.out.println("How many " + allProducts.get(2).getName() + "s do you want to add?");
                                            int quantityToAdd3 = scan1.nextInt();

                                            // Update the quantity of the product
                                            Product selectedProduct3 = allProducts.get(2);
                                            selectedProduct3.setQuantity(quantityToAdd3);

                                            System.out.println(quantityToAdd3 + " " + selectedProduct3.getName() + "(s) added to the cart!");
                                            // logs
                                            assert itemList != null;
                                            itemList.addItem(selectedProduct3);
                                            shoppingCart = ShoppingCart.getInstance(); // Ensure the instance is created
                                            shoppingCart.setCurrentUser(username2);
                                            shoppingCart.addItem(username2, selectedProduct3);
                                            System.out.println("Returning to menu...");
                                            break;
                                        case 4:
                                            System.out.println("How many " + allProducts.get(3).getName() + "s do you want to add?");
                                            int quantityToAdd4 = scan1.nextInt();

                                            // Update the quantity of the product
                                            Product selectedProduct4 = allProducts.get(3);
                                            selectedProduct4.setQuantity(quantityToAdd4);

                                            System.out.println(quantityToAdd4 + " " + selectedProduct4.getName() + "(s) added to the cart!");
                                            // logs
                                            assert itemList != null;
                                            itemList.addItem(selectedProduct4);
                                            shoppingCart = ShoppingCart.getInstance(); // Ensure the instance is created
                                            shoppingCart.setCurrentUser(username2);
                                            shoppingCart.addItem(username2, selectedProduct4);
                                            System.out.println("Returning to menu...");
                                            break;
                                        default:
                                            System.out.println("Please enter an option listed above");
                                            System.out.println("Returning to menu...");
                                            break;
                                    }
                                } else {
                                    System.out.println("You need to log in or sign up before adding items to your cart.");
                                    System.out.println("Returning to menu...");
                                }
                            }

                            break;
                        case 4:
                            if (itemList != null) {
                                System.out.println("Here is Your cart!");
                                if (userAuthentication.isUserLoggedIn() && shoppingCart != null) {
                                    String username2 = userAuthentication.getLoggedInUser().getUsername();
                                    if (!shoppingCart.isEmpty(username2)) {
                                        shoppingCart.displayProducts(username2);
                                        System.out.println("What would you like to do?");
                                        System.out.println(" 1. Checkout\n 2. return to menu\n 3. Empty cart\n 4. Remove items from cart");
                                        int cartChoice = scan1.nextInt();
                                        scan1.nextLine();
                                        switch (cartChoice) {
                                            case 1:
                                                System.out.println("Loading Payment processor...");
                                                PaymentProcessor.paymentProcessor(userList, username2, shoppingCart);
                                                break;
                                            case 2:
                                                System.out.println("Returning to menu...");
                                                break;
                                            case 3:
                                                System.out.println("Emptying cart!");
                                                shoppingCart.emptyCart(username2);
                                                break;
                                            case 4:
                                                System.out.println("Which item would you like to remove? Use the number next to each item's name:");

                                                int itemToRemove = scan1.nextInt() - 1;
                                                shoppingCart.removeItem(username2, itemToRemove);
                                                System.out.println("Returning to menu...");
                                                break;
                                            default:
                                                System.out.println("Please enter an option listed above");
                                                System.out.println("Returning to menu...");
                                                break;
                                        }
                                    }
                                    else {
                                        System.out.println("Your cart is empty! Try adding some stuff first!");
                                        break;
                                        }
                                    }
                            } else {
                                System.out.println("You need to log in or sign up before viewing your cart.");
                                System.out.println("Returning to menu...");
                            }
                            break;
                        case 5:
                            if (!userAuthentication.isUserLoggedIn()) {
                                System.out.println("You're not signed in! Sign in or sign up to access your cart!");
                                System.out.println("Returning to menu...");

                            } else {
                                String username2 = userAuthentication.getLoggedInUser().getUsername();
                                if (shoppingCart == null || shoppingCart.isEmpty(username2)) {
                                    System.out.println("Your cart is empty! Try adding some stuff first!");
                                } else {
                                    System.out.println("Loading Payment processor...");
                                    PaymentProcessor.paymentProcessor(userList, username2, shoppingCart);
                                }


                            }
                            break;
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
                                        System.out.println("Returning to menu...");
                                        break;
                                    default:
                                        System.out.println("Returning to menu...");
                                        System.out.println("Please enter an option listed above");
                                }
                            } else {
                                System.out.println("You're not signed in. Why not try signing in?");
                                System.out.println("Returning to menu...");
                            }
                            break;
                        case 7:
                            if (userList.isEmpty()) {
                                System.out.println("There are no users currently signed in!");
                        }else
                            {
                            userAuthentication.logout();
                            System.out.println("You've been logged out! See ya!");
                            // logs
                            break;
                        }
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
                    System.out.println("Invalid entry detected. Please enter only a number between listed above, thanks.\n");
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
