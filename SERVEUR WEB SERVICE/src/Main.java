import service.AuthService;
import service.CRUDservice;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8087/",new CRUDservice());

        System.out.println("Serveur lance !!!");
    }
}