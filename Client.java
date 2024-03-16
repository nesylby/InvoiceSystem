import java.util.*;

public class Client {
    private static Map<String, List<Double>> clients = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Client Management System ===");
            System.out.println("1. Add Client");
            System.out.println("2. View Clients");
            System.out.println("3. Update Client");
            System.out.println("4. Delete Client");
            System.out.println("5. View Total Billed Amount for a Client");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addClient(scanner);
                    break;
                case 2:
                    viewClients();
                    break;
                case 3:
                    updateClient(scanner);
                    break;
                case 4:
                    deleteClient(scanner);
                    break;
                case 5:
                    viewTotalBilledAmount(scanner);
                    break;
                case 6:
                    System.out.println("Exiting Program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }

    private static void addClient(Scanner scanner) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter total billed amount: $");
        double amount = scanner.nextDouble();

        List<Double> details = new ArrayList<>();
        details.add(amount);
        clients.put(name, details);

        System.out.println("Client added successfully!");
    }

    private static void viewClients() {
        System.out.println("List of Clients:");
        for (Map.Entry<String, List<Double>> entry : clients.entrySet()) {
            String name = entry.getKey();
            double amount = entry.getValue().get(0); // First element is the total billed amount
            System.out.printf("Name: %s, Total Billed Amount: $%.2f%n", name, amount);
        }
    }

    private static void updateClient(Scanner scanner) {
        System.out.print("Enter client name to update: ");
        String name = scanner.nextLine();
        
        if (clients.containsKey(name)) {
            System.out.print("Enter new total billed amount: $");
            double newAmount = scanner.nextDouble();
            
            List<Double> details = clients.get(name);
            details.set(0, newAmount); // Update the total billed amount
            
            System.out.println("Client updated successfully!");
        } else {
            System.out.println("Client not found.");
        }
    }

    private static void deleteClient(Scanner scanner) {
        System.out.print("Enter client name to delete: ");
        String name = scanner.nextLine();
        
        if (clients.containsKey(name)) {
            clients.remove(name);
            System.out.println("Client deleted successfully!");
        } else {
            System.out.println("Client not found.");
        }
    }

    private static void viewTotalBilledAmount(Scanner scanner) {
        System.out.print("Enter client name to view total billed amount: ");
        String name = scanner.nextLine();
        
        if (clients.containsKey(name)) {
            double amount = clients.get(name).get(0); // First element is the total billed amount
            System.out.printf("Total Billed Amount for %s: $%.2f%n", name, amount);
        } else {
            System.out.println("Client not found.");
        }
    }
}
