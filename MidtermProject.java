import java.util.Scanner;

public class MidtermProject {

    public static void main(String[] args) {
        MidtermProject project = new MidtermProject();
        project.startSimulation();
    }

    private void startSimulation() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Invoice System Menu =====");
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Services");
            System.out.println("3. Manage Invoices");
            System.out.println("4. Analytics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageClientsMenu();
                    break;
                case 2:
                    manageServicesMenu();
                    break;
                case 3:
                    manageInvoicesMenu();
                    break;
                case 4:
                    analyticsMenu();
                    break;
                case 5:
                    System.out.println("Exiting the Invoice System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private void manageClientsMenu() {
        // Implement client management options
    }

    private void manageServicesMenu() {
        // Implement service management options
    }

    private void manageInvoicesMenu() {
        // Implement invoice management options
    }

    private void analyticsMenu() {
        // Implement analytics options
    }
}
