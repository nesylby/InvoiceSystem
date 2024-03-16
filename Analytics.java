import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Analytics {

    static HashMap<String, ArrayList<Invoice>> invoicesByClient = new HashMap<>();
    static int invoiceIdCounter = 1;

    public static void main(String[] args) {
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
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 9.");
            }
        }
    }

    public static void createInvoice(Scanner scanner) {
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        ArrayList<Invoice> invoices = invoicesByClient.getOrDefault(clientName, new ArrayList<>());

        Invoice newInvoice = new Invoice(invoiceIdCounter++, clientName);
        invoices.add(newInvoice);

        invoicesByClient.put(clientName, invoices);

        System.out.println("Invoice created successfully with ID: " + newInvoice.getInvoiceId());
    }

    public static void addServiceToInvoice(Scanner scanner) {
        // Code for adding service to invoice (same as before)
    }

    public static void updateServiceHoursInInvoice(Scanner scanner) {
        // Code for updating service hours in invoice (same as before)
    }

    public static void deleteInvoice(Scanner scanner) {
        // Code for deleting invoice (same as before)
    }

    public static void viewInvoicesForClient(Scanner scanner) {
        // Code for viewing invoices for client (same as before)
    }

    public static void totalIncomeForPeriod(Scanner scanner) {
        System.out.print("Enter start date (MM/DD/YYYY): ");
        String startDateStr = scanner.nextLine();

        System.out.print("Enter end date (MM/DD/YYYY): ");
        String endDateStr = scanner.nextLine();

        double totalIncome = 0.0;

        for (ArrayList<Invoice> invoices : invoicesByClient.values()) {
            for (Invoice invoice : invoices) {
                if (invoice.isInPeriod(startDateStr, endDateStr)) {
                    totalIncome += invoice.getTotalAmount();
                }
            }
        }

        System.out.println("Total Income for the Period: $" + totalIncome);
    }

    public static void mostPopularServiceForPeriod(Scanner scanner) {
        System.out.print("Enter start date (MM/DD/YYYY): ");
        String startDateStr = scanner.nextLine();

        System.out.print("Enter end date (MM/DD/YYYY): ");
        String endDateStr = scanner.nextLine();

        HashMap<String, Integer> serviceCount = new HashMap<>();

        for (ArrayList<Invoice> invoices : invoicesByClient.values()) {
            for (Invoice invoice : invoices) {
                if (invoice.isInPeriod(startDateStr, endDateStr)) {
                    for (Map.Entry<String, Double> entry : invoice.getServices().entrySet()) {
                        String serviceName = entry.getKey();
                        serviceCount.put(serviceName, serviceCount.getOrDefault(serviceName, 0) + 1);
                    }
                }
            }
        }

        if (serviceCount.isEmpty()) {
            System.out.println("No services found for the period.");
            return;
        }

        String mostPopularService = Collections.max(serviceCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most Popular Service for the Period: " + mostPopularService);
    }

    public static void topClientForPeriod(Scanner scanner) {
        System.out.print("Enter start date (MM/DD/YYYY): ");
        String startDateStr = scanner.nextLine();

        System.out.print("Enter end date (MM/DD/YYYY): ");
        String endDateStr = scanner.nextLine();

        HashMap<String, Double> clientTotalAmount = new HashMap<>();

        for (String clientName : invoicesByClient.keySet()) {
            double totalAmount = 0.0;
            for (Invoice invoice : invoicesByClient.get(clientName)) {
                if (invoice.isInPeriod(startDateStr, endDateStr)) {
                    totalAmount += invoice.getTotalAmount();
                }
            }
            clientTotalAmount.put(clientName, totalAmount);
        }

        if (clientTotalAmount.isEmpty()) {
            System.out.println("No clients found for the period.");
            return;
        }

        String topClient = Collections.max(clientTotalAmount.entrySet(), Map.Entry.comparingByValue()).getKey();
        double topClientAmount = clientTotalAmount.get(topClient);
        System.out.println("Top Client for the Period: " + topClient + " with Total Amount: $" + topClientAmount);
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

        public void displayServices() {
            System.out.println("Services in Invoice " + invoiceId + ":");
            for (Map.Entry<String, Double> entry : services.entrySet()) {
                System.out.println("Service: " + entry.getKey() + ", Hours: " + entry.getValue());
            }
        }

        public double getTotalAmount() {
            double total = 0.0;
            for (Double hours : services.values()) {
                total += hours * 50; // Assuming $50 per hour
            }
            return total;
        }

        public boolean isInPeriod(String startDateStr, String endDateStr) {
            // Parsing dates for comparison
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {
                Date startDate = sdf.parse(startDateStr);
                Date endDate = sdf.parse(endDateStr);

                // Checking if invoice date falls within the given period
                return !(endDate.before(getInvoiceDate()) || startDate.after(getInvoiceDate()));

            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }

        private Date getInvoiceDate() {
            // Here you would implement a method to get the invoice date.
            // For the sake of this example, we'll just return the current date.
            return new Date();
        }

        public HashMap<String, Double> getServices() {
            return services;
        }
    }
}
