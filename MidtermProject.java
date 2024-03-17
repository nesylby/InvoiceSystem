import java.util.Scanner;

public class MidtermProject extends DatabaseManager {

    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Invoice Management System ===");
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
                    clientManagementMenu(databaseManager, scanner);
                    break;
                case 2:
                    serviceManagementMenu(databaseManager, scanner);
                    break;
                case 3:
                    invoiceManagementMenu(databaseManager, scanner);
                    break;
                case 4:
                    analyticsMenu(databaseManager, scanner);
                    break;
                case 5:
                    System.out.println("Exiting Program. Goodbye!");
                    scanner.close();
                    databaseManager.closeConnection();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    public static void clientManagementMenu(DatabaseManager databaseManager, Scanner scanner) {
        System.out.println("Client Management Menu:");
        System.out.println("1. Add Client");
        System.out.println("2. View Clients");
        System.out.println("3. Update Client");
        System.out.println("4. Delete Client");
        System.out.println("5. View Total Billed Amount for Client");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        switch (choice) {
            case 1:
                addClient(databaseManager, scanner);
                break;
            case 2:
                databaseManager.viewClients();
                break;
            case 3:
                updateClient(databaseManager, scanner);
                break;
            case 4:
                deleteClient(databaseManager, scanner);
                break;
            case 5:
                viewTotalBilledAmount(databaseManager, scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void addClient(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();
        System.out.print("Enter contact information: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter billing address: ");
        String billingAddress = scanner.nextLine();

        databaseManager.addClient(clientName, contactInfo, billingAddress);
    }

    public static void updateClient(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter client ID to update: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter new client name: ");
        String newClientName = scanner.nextLine();
        System.out.print("Enter new contact information: ");
        String newContactInfo = scanner.nextLine();
        System.out.print("Enter new billing address: ");
        String newBillingAddress = scanner.nextLine();

        databaseManager.updateClient(clientId, newClientName, newContactInfo, newBillingAddress);
    }

    public static void deleteClient(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter client ID to delete: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        databaseManager.deleteClient(clientId);
    }

    public static void viewTotalBilledAmount(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter client ID to view total billed amount: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        double totalAmount = databaseManager.getTotalBilledAmount(clientId);
        System.out.println("Total Billed Amount for Client ID " + clientId + ": $" + totalAmount);
    }

    public static void serviceManagementMenu(DatabaseManager databaseManager, Scanner scanner) {
        System.out.println("Service Management Menu:");
        System.out.println("1. Add Service");
        System.out.println("2. View Services");
        System.out.println("3. Update Service");
        System.out.println("4. Delete Service");
        System.out.println("5. View Total Hours Billed for Service");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        switch (choice) {
            case 1:
                addService(databaseManager, scanner);
                break;
            case 2:
                databaseManager.viewServices();
                break;
            case 3:
                updateService(databaseManager, scanner);
                break;
            case 4:
                deleteService(databaseManager, scanner);
                break;
            case 5:
                viewTotalHoursBilled(databaseManager, scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void addService(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter service name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Enter hourly rate: ");
        double hourlyRate = scanner.nextDouble();
        scanner.nextLine();  // Consume newline character

        databaseManager.addService(serviceName, hourlyRate);
    }

    public static void updateService(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter service ID to update: ");
        int serviceId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter new service name: ");
        String newServiceName = scanner.nextLine();
        System.outimport java.util.Scanner;

        public class MidtermProject {
        
            public static void main(String[] args) {
                DatabaseManager databaseManager = new DatabaseManager();
                Scanner scanner = new Scanner(System.in);
        
                while (true) {
                    System.out.println("\n=== Invoice Management System ===");
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
                            clientManagementMenu(databaseManager, scanner);
                            break;
                        case 2:
                            serviceManagementMenu(databaseManager, scanner);
                            break;
                        case 3:
                            invoiceManagementMenu(databaseManager, scanner);
                            break;
                        case 4:
                            analyticsMenu(databaseManager, scanner);
                            break;
                        case 5:
                            System.out.println("Exiting Program. Goodbye!");
                            scanner.close();
                            databaseManager.closeConnection();
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    }
                }
            }
        
            public static void clientManagementMenu(DatabaseManager databaseManager, Scanner scanner) {
                System.out.println("Client Management Menu:");
                System.out.println("1. Add Client");
                System.out.println("2. View Clients");
                System.out.println("3. Update Client");
                System.out.println("4. Delete Client");
                System.out.println("5. View Total Billed Amount for Client");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
        
                switch (choice) {
                    case 1:
                        addClient(databaseManager, scanner);
                        break;
                    case 2:
                        databaseManager.viewClients();
                        break;
                    case 3:
                        updateClient(databaseManager, scanner);
                        break;
                    case 4:
                        deleteClient(databaseManager, scanner);
                        break;
                    case 5:
                        viewTotalBilledAmount(databaseManager, scanner);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        
            public static void addClient(DatabaseManager databaseManager, Scanner scanner) {
                System.out.print("Enter client name: ");
                String clientName = scanner.nextLine();
                System.out.print("Enter contact information: ");
                String contactInfo = scanner.nextLine();
                System.out.print("Enter billing address: ");
                String billingAddress = scanner.nextLine();
        
                databaseManager.addClient(clientName, contactInfo, billingAddress);
            }
        
            public static void updateClient(DatabaseManager databaseManager, Scanner scanner) {
                System.out.print("Enter client ID to update: ");
                int clientId = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
                System.out.print("Enter new client name: ");
                String newClientName = scanner.nextLine();
                System.out.print("Enter new contact information: ");
                String newContactInfo = scanner.nextLine();
                System.out.print("Enter new billing address: ");
                String newBillingAddress = scanner.nextLine();
        
                databaseManager.updateClient(clientId, newClientName, newContactInfo, newBillingAddress);
            }
        
            public static void deleteClient(DatabaseManager databaseManager, Scanner scanner) {
                System.out.print("Enter client ID to delete: ");
                int clientId = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
        
                databaseManager.deleteClient(clientId);
            }
        
            public static void viewTotalBilledAmount(DatabaseManager databaseManager, Scanner scanner) {
                System.out.print("Enter client ID to view total billed amount: ");
                int clientId = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
        
                double totalAmount = databaseManager.getTotalBilledAmount(clientId);
                System.out.println("Total Billed Amount for Client ID " + clientId + ": $" + totalAmount);
            }
        
            public static void serviceManagementMenu(DatabaseManager databaseManager, Scanner scanner) {
                System.out.println("Service Management Menu:");
                System.out.println("1. Add Service");
                System.out.println("2. View Services");
                System.out.println("3. Update Service");
                System.out.println("4. Delete Service");
                System.out.println("5. View Total Hours Billed for Service");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
        
                switch (choice) {
                    case 1:
                        addService(databaseManager, scanner);
                        break;
                    case 2:
                        databaseManager.viewServices();
                        break;
                    case 3:
                        updateService(databaseManager, scanner);
                        break;
                    case 4:
                        deleteService(databaseManager, scanner);
                        break;
                    case 5:
                        viewTotalHoursBilled(databaseManager, scanner);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        
            public static void addService(DatabaseManager databaseManager, Scanner scanner) {
                System.out.print("Enter service name: ");
                String serviceName = scanner.nextLine();
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                scanner.nextLine();  // Consume newline character
        
                databaseManager.addService(serviceName, hourlyRate);
            }
        
            public static void updateService(DatabaseManager databaseManager, Scanner scanner) {
                System.out.print("Enter service ID to update: ");
                int serviceId = scanner.nextInt();
                scanner.nextLine();  // Consume newline character
                System.out.print("Enter new service name: ");
                String newServiceName = scanner.nextLine();
                System.out
        
