import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // initializing new scanner
    private static Scanner scanner = new Scanner(System.in);

    // initializing HashMap - Storing user data
    // <V, K> <Username, Amount>
    private static HashMap<String, Double> person = new HashMap<>();

    public static void main(String[] args) {

        // this while loop, keeps atm running even if transaction is cancelled.
        while (true) {

            // adding artificial persons to HashMap
            person.put("Steve", 45.00);
            person.put("Lisa", 85.00);
            person.put("Gary", 145.00);
            person.put("Raymond", 120.00);

            // setting String labeled account to scanner
            System.out.println("Welcome! \n Please sign in...");
            String account = scanner.nextLine();
            // waiting for input, if no valid key entry add new <key,value>

            // added logic to limit double to 2 decimal points
            person.putIfAbsent(account, (double) Math.round(Math.random() * 100));
            System.out.println("Hello, " + account);

            /* Showing three options
            looping options until user cancels
            HashMap should keep previously-set values when it loops */

            // this looks silly, can i use something else, rather than an int?
            int t = 1;
            while (t == 1) {

                System.out.println("Choose an option:");
                System.out.println("[ 1 ] Check Balance \n[ 2 ] Withdraw \n[ 3 ] Remove Account \n" +
                        "[ 4 ] Cancel Transaction");

                String option = scanner.nextLine();

                // switch for options
                switch (option) {

                    case "1":

                        System.out.println("Your balance is $" + person.get(account) + "\n");
                        break;

                    case "2":

                        System.out.println("Please enter withdraw amount");
                        String withdrawAmount = scanner.nextLine();

                        // changing String withdraw amount to double
                        double wAmount = Double.valueOf(withdrawAmount);

                        // pulling value from HashMap and subtracting withdraw from value
                        double currentAmount = person.get(account);
                        double total = Double.valueOf(currentAmount - wAmount);

                        //replacing oldValue with newValue
                        person.replace(account, total);

                        System.out.print("Printing... $" + withdrawAmount + " \n Please Remove cash... \n");
                        System.out.println("You have $" + total + " left in your account.\n");
                        break;

                    case "3":

                        System.out.println("To delete you account, enter your name.");
                        String remove = scanner.nextLine();
                        person.remove(remove);
                        break;

                    case "4":

                        System.out.println("\n Transaction canceled. \n \n");
                        t = 2;
                        break;
                }
            }
        }
    }
}