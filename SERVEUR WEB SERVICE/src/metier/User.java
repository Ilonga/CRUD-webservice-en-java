package metier;

import java.io.Serializable;

public class User implements Serializable {
    private String nomUser;
    private int idUser;
    private String password;
    private String login;

    public User() {

    }

    public User(String nomUser, int idUser, String password, String login) {
        this.nomUser = nomUser;
        this.idUser = idUser;
        this.password = password;
        this.login = login;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
