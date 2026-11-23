import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for the calculator service.
 */
public interface CalculatorService extends Remote {
    double add(double a, double b) throws RemoteException;
    double subtract(double a, double b) throws RemoteException;
    double multiply(double a, double b) throws RemoteException;
    double divide(double a, double b) throws RemoteException;
}
