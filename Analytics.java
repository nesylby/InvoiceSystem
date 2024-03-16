import java.sql.*;
import java.time.LocalDate;

public class Analytics {

    // Total income for a given period
    public static double getTotalIncomeForPeriod(LocalDate startDate, LocalDate endDate) {
        double totalIncome = 0;
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(total_amount) AS total_income FROM invoices WHERE invoice_date BETWEEN ? AND ?")) {
            preparedStatement.setDate(1, Date.valueOf(startDate));
            preparedStatement.setDate(2, Date.valueOf(endDate));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    totalIncome = resultSet.getDouble("total_income");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalIncome;
    }

    // Most popular service for a given period
    public static String getMostPopularServiceForPeriod(LocalDate startDate, LocalDate endDate) {
        String mostPopularService = "";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT s.service_name, SUM(ii.hours) AS total_hours " +
                                                                                 "FROM services s " +
                                                                                 "JOIN invoice_items ii ON s.service_id = ii.service_id " +
                                                                                 "JOIN invoices i ON ii.invoice_id = i.invoice_id " +
                                                                                 "WHERE i.invoice_date BETWEEN ? AND ? " +
                                                                                 "GROUP BY s.service_name " +
                                                                                 "ORDER BY total_hours DESC " +
                                                                                 "LIMIT 1")) {
            preparedStatement.setDate(1, Date.valueOf(startDate));
            preparedStatement.setDate(2, Date.valueOf(endDate));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    mostPopularService = resultSet.getString("service_name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mostPopularService;
    }

    // Top client for a given period
    public static String getTopClientForPeriod(LocalDate startDate, LocalDate endDate) {
        String topClient = "";
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.client_name, SUM(i.total_amount) AS total_amount " +
                                                                                 "FROM clients c " +
                                                                                 "JOIN invoices i ON c.client_id = i.client_id " +
                                                                                 "WHERE i.invoice_date BETWEEN ? AND ? " +
                                                                                 "GROUP BY c.client_name " +
                                                                                 "ORDER BY total_amount DESC " +
                                                                                 "LIMIT 1")) {
            preparedStatement.setDate(1, Date.valueOf(startDate));
            preparedStatement.setDate(2, Date.valueOf(endDate));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    topClient = resultSet.getString("client_name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topClient;
    }
}
