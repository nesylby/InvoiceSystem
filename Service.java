import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private int id;
    private String name;
    private double rate;

    public Service(int id, String name, double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    // CRUD Operations

    // Create a new service
    public void addService() {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO services (service_name, service_rate) VALUES (?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, rate);
            preparedStatement.executeUpdate();
            System.out.println("Service added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all services
    public static List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM services")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                double rate = resultSet.getDouble("service_rate");
                services.add(new Service(id, name, rate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    // Update service information
    public void updateService() {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE services SET service_name = ?, service_rate = ? WHERE service_id = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, rate);
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Service updated successfully.");
            } else {
                System.out.println("Service with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a service
    public void deleteService() {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM services WHERE service_id = ?")) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Service deleted successfully.");
            } else {
                System.out.println("Service with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
