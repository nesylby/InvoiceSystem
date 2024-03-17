import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Analytics {

    static Connection connection;

    public static void main(String[] args) {
        connectToDatabase();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Invoice Management System ===");
            System.out.println("1. Create Invoice");
            System.out.println("2. Add Service to Invoice");
            System.out.println("3. Update Service Hours in Invoice");
            System.out.println("4. Delete Invoice");
            System.out.println("5. View Invoices for Client");
            System.out.println("6. Total Income for a Given Period");
            System.out.println("7. Most Popular Service for a Given Period");
            System.out.println("8. Top Client for a Given Period");
            System.out.println("9. Exit");

            System.out.print("Enter your choice (1-9): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createInvoice(scanner);
                    break;
                case 2:
                    addServiceToInvoice(scanner);
                    break;
                case 3:
                    updateServiceHoursInInvoice(scanner);
                    break;
                case 4:
                    deleteInvoice(scanner);
                    break;
                case 5:
                    viewInvoicesForClient(scanner);
                    break;
                case 6:
                    totalIncomeForPeriod(scanner);
                    break;
                case 7:
                    mostPopularServiceForPeriod(scanner);
                    break;
                case 8:
                    topClientForPeriod(scanner);
                    break;
                case 9:
                    System.out.println("Exiting Program. Goodbye!");
                    scanner.close();
                    closeDatabaseConnection();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 9.");
            }
        }
    }

    public static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicesys", "your_username", "your_password");
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }

    public static void closeDatabaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
        }
    }

    public static void createInvoice(Scanner scanner) {
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        // Your database insert logic for creating a new invoice
    }

    public static void addServiceToInvoice(Scanner scanner) {
        // Your database insert logic for adding service to an invoice
    }

    public static void updateServiceHoursInInvoice(Scanner scanner) {
        // Your database update logic for updating service hours in an invoice
    }

    public static void deleteInvoice(Scanner scanner) {
        // Your database delete logic for deleting an invoice
    }

    public static void viewInvoicesForClient(Scanner scanner) {
        // Your database query logic for viewing invoices for a client
    }

    public static void totalIncomeForPeriod(Scanner scanner) {
        System.out.print("Enter start date (MM/DD/YYYY): ");
        String startDateStr = scanner.nextLine();

        System.out.print("Enter end date (MM/DD/YYYY): ");
        String endDateStr = scanner.nextLine();

        double totalIncome = 0.0;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM invoices WHERE date BETWEEN ? AND ?");
            statement.setString(1, startDateStr);
            statement.setString(2, endDateStr);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                totalIncome += resultSet.getDouble("total_amount");
            }

            System.out.println("Total Income for the Period: $" + totalIncome);

        } catch (SQLException e) {
            System.err.println("Error retrieving total income: " + e.getMessage());
        }
    }

    public static void mostPopularServiceForPeriod(Scanner scanner) {
        // Your database query logic for finding the most popular service for a period
    }

    public static void topClientForPeriod(Scanner scanner) {
        // Your database query logic for finding the top client for a period
    }

    public static Invoice findInvoiceById(ArrayList<Invoice> invoices, int invoiceId) {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceId() == invoiceId) {
                return invoice;
            }
        }
        return null;
    }

    static class Invoice {
        private int invoiceId;
        private String clientName;
        private HashMap<String, Double> services;

        public Invoice(int invoiceId, String clientName) {
            this.invoiceId = invoiceId;
            this.clientName = clientName;
            this.services = new HashMap<>();
        }

        public int getInvoiceId() {
            return invoiceId;
        }

        public void addService(String serviceName, double hoursBilled) {
            services.put(serviceName, hoursBilled);
        }

        public void updateServiceHours(String serviceName, double newHours) {
            if (services.containsKey(serviceName)) {
                services.put(serviceName, newHours);
            } else {
                System.out.println("Service not found in invoice.");
            }
        }
    }
