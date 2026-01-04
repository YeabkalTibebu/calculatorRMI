import java.rmi.*;
import java.rmi.server.*;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {

    public CalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    public int divide(int a, int b) throws RemoteException {
        if (b == 0) throw new RemoteException("Division by zero");
        return a / b;
    }

    public static void main(String args[]) {
        try {
            
            CalculatorImpl server = new CalculatorImpl();
            Naming.rebind("CalculatorService", server);
            System.out.println("Server waiting.....");
        } catch (Exception e) {
            System.out.println("Remote exception: " + e.toString());
        }
    }
}