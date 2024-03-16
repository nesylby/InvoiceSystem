import java.util.*;

public class InvoiceManagement {

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
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
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
                    System.out.println("Exiting Program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
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
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        if (!invoicesByClient.containsKey(clientName)) {
            System.out.println("No invoices found for client: " + clientName);
            return;

}

ArrayList<Invoice> invoices = invoicesByClient.get(clientName);
System.out.print("Enter invoice ID: ");
int invoiceId = scanner.nextInt();
scanner.nextLine();  // Consume newline character

Invoice invoice = findInvoiceById(invoices, invoiceId);
if (invoice == null) {
    System.out.println("Invoice not found with ID: " + invoiceId);
    return;
}

System.out.print("Enter service name: ");
String serviceName = scanner.nextLine();

System.out.print("Enter hours billed for this service: ");
double hoursBilled = scanner.nextDouble();
scanner.nextLine();  // Consume newline character

invoice.addService(serviceName, hoursBilled);

System.out.println("Service added to invoice successfully.");
}

public static void updateServiceHoursInInvoice(Scanner scanner) {
System.out.print("Enter client name: ");
String clientName = scanner.nextLine();

if (!invoicesByClient.containsKey(clientName)) {
    System.out.println("No invoices found for client: " + clientName);
    return;
}

ArrayList<Invoice> invoices = invoicesByClient.get(clientName);
System.out.print("Enter invoice ID: ");
int invoiceId = scanner.nextInt();
scanner.nextLine();  // Consume newline character

Invoice invoice = findInvoiceById(invoices, invoiceId);
if (invoice == null) {
    System.out.println("Invoice not found with ID: " + invoiceId);
    return;
}

invoice.displayServices();

System.out.print("Enter service name to update hours: ");
String serviceName = scanner.nextLine();

System.out.print("Enter new hours billed for this service: ");
double newHours = scanner.nextDouble();
scanner.nextLine();  // Consume newline character

invoice.updateServiceHours(serviceName, newHours);

System.out.println("Service hours updated successfully.");
}

public static void deleteInvoice(Scanner scanner) {
System.out.print("Enter client name: ");
String clientName = scanner.nextLine();

if (!invoicesByClient.containsKey(clientName)) {
    System.out.println("No invoices found for client: " + clientName);
    return;
}

ArrayList<Invoice> invoices = invoicesByClient.get(clientName);
System.out.print("Enter invoice ID to delete: ");
int invoiceId = scanner.nextInt();
scanner.nextLine();  // Consume newline character

Invoice invoice = findInvoiceById(invoices, invoiceId);
if (invoice == null) {
    System.out.println("Invoice not found with ID: " + invoiceId);
    return;
}

invoices.remove(invoice);

System.out.println("Invoice deleted successfully.");
}

public static void viewInvoicesForClient(Scanner scanner) {
System.out.print("Enter client name: ");
String clientName = scanner.nextLine();

if (!invoicesByClient.containsKey(clientName)) {
    System.out.println("No invoices found for client: " + clientName);
    return;
}

ArrayList<Invoice> invoices = invoicesByClient.get(clientName);

System.out.println("\nInvoices for Client: " + clientName);
for (Invoice invoice : invoices) {
    System.out.println("Invoice ID: " + invoice.getInvoiceId());
    invoice.displayServices();
    System.out.println("Total Amount: $" + invoice.getTotalAmount());
    System.out.println("-------------------------");
}
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
}
}
