package service;

import metier.User;
import metier.UserRepository;

import java.sql.SQLException;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        try {
            userRepository.createUser(user);
        } catch (SQLException e) {
            // Gérer l'exception de manière appropriée
            throw new RuntimeException("Erreur lors de la création de l'utilisateur", e);
        }
    }

    public User getUser(int idUser) {
        try {
            return userRepository.getUser(idUser);
        } catch (SQLException e) {
            // Gérer l'exception de manière appropriée
            throw new RuntimeException("Erreur lors de la récupération de l'utilisateur", e);
        }
    }

    public void updateUser(User user) {
        try {
            userRepository.updateUser(user);
        } catch (SQLException e) {
            // Gérer l'exception de manière appropriée
            throw new RuntimeException("Erreur lors de la mise à jour de l'utilisateur", e);
        }
    }

    public void deleteUser(int idUser) {
        try {
            userRepository.deleteUser(idUser);
        } catch (SQLException e) {
            // Gérer l'exception de manière appropriée
            throw new RuntimeException("Erreur lors de la suppression de l'utilisateur", e);
        }
    }
}
