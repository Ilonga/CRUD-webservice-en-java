package service;

import metier.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "AS")
public class AuthService {
    @WebMethod(operationName = "connexion")
    public User seConnecter(@WebParam(name = "login")  String login,@WebParam(name = "password ") String password){
        if(login.equals("admin")  && password.equals("1234")){
            return new User("aggee",1,password,login);
        }else {
            return null;
        }
    }
}
