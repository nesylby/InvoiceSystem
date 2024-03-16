import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private int id;
    private int clientId;
    private LocalDate date;
    private double totalAmount;

    public Invoice(int id, int clientId, LocalDate date, double totalAmount) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // CRUD Operations

    // Create a new invoice
    public void addInvoice() {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO invoices (client_id, invoice_date, total_amount) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, clientId);
            preparedStatement.setDate(2, Date.valueOf(date));
            preparedStatement.setDouble(3, totalAmount);
            preparedStatement.executeUpdate();
            System.out.println("Invoice added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all invoices for a client
    public static List<Invoice> getAllInvoicesForClient(int clientId) {
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM invoices WHERE client_id = ?")) {
            preparedStatement.setInt(1, clientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("invoice_id");
                    LocalDate date = resultSet.getDate("invoice_date").toLocalDate();
                    double totalAmount = resultSet.getDouble("total_amount");
                    invoices.add(new Invoice(id, clientId, date, totalAmount));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    // Update invoice information
    public void updateInvoice() {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE invoices SET client_id = ?, invoice_date = ?, total_amount = ? WHERE invoice_id = ?")) {
            preparedStatement.setInt(1, clientId);
            preparedStatement.setDate(2, Date.valueOf(date));
            preparedStatement.setDouble(3, totalAmount);
            preparedStatement.setInt(4, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Invoice updated successfully.");
            } else {
                System.out.println("Invoice with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an invoice
    public void deleteInvoice() {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM invoices WHERE invoice_id = ?")) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Invoice deleted successfully.");
            } else {
                System.out.println("Invoice with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
