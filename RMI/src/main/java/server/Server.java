package server;

import interfaces.NumberRemote;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server implements NumberRemote {

    public Server() {
    }

    public List<Integer> getNumber(int number) throws RemoteException {

        List<Integer> numbers = new ArrayList<Integer>();

        while (number != 0) {
            numbers.add(number % 10);
            number = number / 10;
        }

        return numbers;
    }

    public static void main(String[] args){

        try {
            Server server = new Server();
            NumberRemote numberRemote = (NumberRemote) UnicastRemoteObject.exportObject(server,8080);

            Registry registry= LocateRegistry.createRegistry(1234);
            registry.bind("Hello", server);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception "+ e.toString());
            e.printStackTrace();
        }


    }
}
