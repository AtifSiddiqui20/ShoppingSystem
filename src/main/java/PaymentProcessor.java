import java.util.Scanner;

public class PaymentProcessor {

    public static void paymentProcessor(UserList userList, String username, ShoppingCart shoppingCart) {
        Scanner scanner = new Scanner(System.in);
        User user = userList.getUser(username);
        System.out.println("------------------------------------");
        System.out.println("Welcome to the payment processor!");
        if (user == null) {
            System.out.println("DEBUG: User is null. Username: " + username);
            return;
        } else if (user.getCreditCard() == null) {
            System.out.println("It seems you don't have credit card information saved. Please provide the following details:");


            System.out.println("Full Name: ");
            String name = scanner.nextLine();

            System.out.println("Credit Card Number: ");
            String ccInfo = scanner.nextLine();

            System.out.println("Address: ");
            String Address = scanner.nextLine();
            user.setCreditCard(name + "\n" + ccInfo + "\n (Address: " + Address + ")");
            userList.updateUserInfo(username, name, ccInfo, Address);
            System.out.println("Information saved successfully!");


        }
        System.out.println("Here is your cart and payment information, please confirm it is correct before proceeding");
        double total = shoppingCart.displayProducts(username);
        System.out.println("User information:\n" + "Name: " + user.getName() + "\nAddress: " + user.getAddress()
        + "\nPayment information: " + user.getCreditCard());
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("Shipping price:   FREE");
        System.out.printf("\nOrder total = total x .07 tax\nOrder Total  = $%.2f\n",  ((total*.07) + total));
        System.out.println("Please enter 1 to confirm or 2 to return to the main menu");

        try {
            int paymentChoice = scanner.nextInt();
            if (paymentChoice == 1) {
                System.out.println("Processing payment...");
                shoppingCart.emptyCart(username);
                Logger.log("Payment has been processed, returning to main menu");
                System.out.println("Order successful! Thanks for visiting the Penguin Emporium!");
                System.out.println("We hope you'll love your new penguins, please come again!");
                System.out.println("Returning to main menu...");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        }
    }
    }


