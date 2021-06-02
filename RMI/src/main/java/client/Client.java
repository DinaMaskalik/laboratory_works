package client;

import interfaces.NumberRemote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        try {
            String number = (args.length < 1) ? "0" : args[0];

            Registry registry = LocateRegistry.getRegistry(1234);

            NumberRemote numberRemote = (NumberRemote) registry.lookup("Hello");
            List<Integer> response = numberRemote.getNumber(Integer.parseInt(number));

            System.out.println("Response:");

            response.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Client exception "+ e.toString());
        }
    }
}
