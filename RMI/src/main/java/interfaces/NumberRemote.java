package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface NumberRemote extends Remote {
    List<Integer> getNumber(int number) throws RemoteException;
}
