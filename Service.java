import java.util.*;

public class Service {

    static HashMap<String, ArrayList<Double>> services = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Service Management System ===");
            System.out.println("1. Add Service");
            System.out.println("2. View Services");
            System.out.println("3. Update Service");
            System.out.println("4. Delete Service");
            System.out.println("5. View Total Hours Billed for a Service");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addService(scanner);
                    break;
                case 2:
                    viewServices();
                    break;
                case 3:
                    updateService(scanner);
                    break;
                case 4:
                    deleteService(scanner);
                    break;
                case 5:
                    viewTotalHoursBilled(scanner);
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

    public static void addService(Scanner scanner) {
        System.out.print("Enter service name: ");
        String name = scanner.nextLine();

        System.out.print("Enter total hours billed for this service: ");
        double totalHours = scanner.nextDouble();

        ArrayList<Double> details = new ArrayList<>();
        details.add(totalHours);

        services.put(name, details);
        System.out.println("Service added successfully!");
    }

    public static void viewServices() {
        System.out.println("\nList of Services:");
        for (Map.Entry<String, ArrayList<Double>> entry : services.entrySet()) {
            String name = entry.getKey();
            ArrayList<Double> details = entry.getValue();
            System.out.println("Service: " + name + ", Total Hours Billed: " + details.get(0));
        }
    }

    public static void updateService(Scanner scanner) {
        System.out.print("Enter service name to update: ");
        String name = scanner.nextLine();

        if (services.containsKey(name)) {
            System.out.print("Enter new total hours billed: ");
            double newTotalHours = scanner.nextDouble();

            ArrayList<Double> details = services.get(name);
            details.set(0, newTotalHours);

            System.out.println("Service updated successfully!");
        } else {
            System.out.println("Service not found.");
        }
    }

    public static void deleteService(Scanner scanner) {
        System.out.print("Enter service name to delete: ");
        String name = scanner.nextLine();

        if (services.containsKey(name)) {
            services.remove(name);
            System.out.println("Service deleted successfully!");
        } else {
            System.out.println("Service not found.");
        }
    }

    public static void viewTotalHoursBilled(Scanner scanner) {
        System.out.print("Enter service name to view total hours billed: ");
        String name = scanner.nextLine();

        if (services.containsKey(name)) {
            ArrayList<Double> details = services.get(name);
            System.out.println("Total Hours Billed for " + name + ": " + details.get(0));
        } else {
            System.out.println("Service not found.");
        }
    }
}
