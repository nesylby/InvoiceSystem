import java.util.Scanner;

public class MidtermProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Midterm Project: Invoice Management System ===");
            System.out.println("1. Client Management");
            System.out.println("2. Service Management");
            System.out.println("3. Invoice Management");
            System.out.println("4. Analytics");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    clientManagementMenu(scanner);
                    break;
                case 2:
                    serviceManagementMenu(scanner);
                    break;
                case 3:
                    invoiceManagementMenu(scanner);
                    break;
                case 4:
                    analyticsMenu(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Midterm Project. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    public static void clientManagementMenu(Scanner scanner) {
        // Implement client management menu if needed
        System.out.println("Client Management Menu - Feature not implemented yet.");
    }

    public static void serviceManagementMenu(Scanner scanner) {
        // Implement service management menu if needed
        System.out.println("Service Management Menu - Feature not implemented yet.");
    }

    public static void invoiceManagementMenu(Scanner scanner) {
        // Implement invoice management menu if needed
        System.out.println("Invoice Management Menu - Feature not implemented yet.");
    }

    public static void analyticsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Analytics Menu ===");
            System.out.println("1. Total Income for a Given Period");
            System.out.println("2. Most Popular Service for a Given Period");
            System.out.println("3. Top Client for a Given Period");
            System.out.println("4. Back to Main Menu");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    Analytics.totalIncomeForPeriod(scanner);
                    break;
                case 2:
                    Analytics.mostPopularServiceForPeriod(scanner);
                    break;
                case 3:
                    Analytics.topClientForPeriod(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }
}
