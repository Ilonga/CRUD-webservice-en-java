package service;

import metier.User;
import metier.UserModel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;

@WebService(serviceName = "CRUDService")
public class CRUDservice {
    private UserModel userModel = new UserModel();

    @WebMethod(operationName = "createUser")
    public String createUser(
            @WebParam(name = "nomUser") String nomUser,
            @WebParam(name = "password") String password,
            @WebParam(name = "login") String login) {
        try {
            User user = new User(nomUser, 0, password, login);
            userModel.createUser(user);
            return "Creation de l'utilisateur reussie avec succes !";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la creation de l'utilisateur  " + e.getMessage();
        }
    }

    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "idUser") int idUser) {
        try {
            return userModel.getUser(idUser);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @WebMethod(operationName = "updateUser")
    public String updateUser(
            @WebParam(name = "idUser") int idUser,
            @WebParam(name = "nomUser") String nomUser,
            @WebParam(name = "password") String password,
            @WebParam(name = "login") String login) {
        try {
            User user = new User(nomUser, idUser, password, login);
            userModel.updateUser(user);
            return "Mise a jour reussie avec succes !";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la mise a jour de l'utilisateur : " + e.getMessage();
        }
    }

    @WebMethod(operationName = "deleteUser")
    public String deleteUser(@WebParam(name = "idUser") int idUser) {
        try {
            userModel.deleteUser(idUser);
            return "La suppression reussie avec succes !";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la suppression de l'utilisateur : " + e.getMessage();
        }
    }
}

