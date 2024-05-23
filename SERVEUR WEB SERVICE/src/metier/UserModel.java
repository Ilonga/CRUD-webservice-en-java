package metier;

import java.sql.*;

public class UserModel implements UserRepository {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/app_repartie";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    static {
        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Échec du chargement du driver JDBC", e);
        }
    }

    // Create (Insert)
    @Override
    public void createUser(User user) throws SQLException {
        String query = "INSERT INTO utilisateurs (nomuser, password, login) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getNomUser());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.executeUpdate();
        }
    }

    // Read (Select)
    @Override
    public User getUser(int idUser) throws SQLException {
        String query = "SELECT * FROM utilisateurs WHERE iduser = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getString("nomuser"),
                            resultSet.getInt("iduser"),
                            resultSet.getString("password"),
                            resultSet.getString("login")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    // Update
    @Override
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE utilisateurs SET nomuser = ?, password = ?, login = ? WHERE iduser = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getNomUser());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setInt(4, user.getIdUser());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected == 0) {
                throw new SQLException("Aucune ligne mise a jour. L'ID utilisateur n'existe peut etre pas.");
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            throw e; // rethrow the exception after logging it
        }
    }


    // Delete
    @Override
    public void deleteUser(int idUser) throws SQLException {
        String query = "DELETE FROM utilisateurs WHERE iduser = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idUser);
            preparedStatement.executeUpdate();
        }
    }
}
