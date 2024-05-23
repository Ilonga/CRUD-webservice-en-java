package metier;

import java.sql.SQLException;

public interface UserRepository {
    void createUser(User user) throws SQLException;
    User getUser(int idUser) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(int idUser) throws SQLException;
}
