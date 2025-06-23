import java.util.Scanner;
import java.time.format.DateTimeFormatter;


public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println(" Currency Converter ");
            System.out.println("1. Convert SEK to USD");
            System.out.println("2. Convert SEK to EUR");
            System.out.println("3. Convert USD to SEK");
            System.out.println("4. Convert EUR to SEK");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    convert(scanner, "SEK", "USD");
                    break;
                case "2":
                    convert(scanner, "SEK", "EUR");
                    break;
                case "3":
                    convert(scanner, "USD", "SEK");
                    break;
                case "4":
                    convert(scanner, "EUR", "SEK");
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }
        scanner.close();
    }

    public static void convert(Scanner scanner, String from, String to) {
        System.out.print("Enter amount in " + from + ": ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            CurrencyConverter.convert(from, to, amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Enter a valid number.");

        }

    }

    public static void convert(String from, String to, double amount) {
        double result;

        // Exchange rates as of 2025/06/19

        double SEK_TO_USD = 9.65;
        double SEK_TO_EUR = 11.06;
        double USD_TO_SEK = 9.65;
        double EUR_TO_SEK = 11.06;

        if (amount < 0) {
            System.out.println("Amount can´t be negative.");
            return;
        }

        if (from.equals("SEK") && to.equals("USD")) {
            result = amount * SEK_TO_USD;
        } else if (from.equals("SEK") && to.equals("EUR")) {
            result = amount * SEK_TO_EUR;
        } else if (from.equals("USD") && to.equals("SEK")) {
            result = amount * USD_TO_SEK;
        } else if (from.equals("EUR") && to.equals("SEK")) {
            result = amount * EUR_TO_SEK;
        } else {
            System.out.println("Conversion not supported.");
            return;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        java.time.LocalDateTime now = java.time.LocalDateTime.now();

        System.out.println("Converted: " + amount + " " + from + " = " + result + " " + to);
        System.out.println("Date and Time: " + dtf.format(now));
    }


}
