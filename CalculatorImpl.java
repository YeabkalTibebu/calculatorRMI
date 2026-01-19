import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    protected CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Cannot divide by zero!");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            Calculator calc = new CalculatorImpl();
            Naming.rebind("CalculatorService", calc);
            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            System.err.println("Server error: " + e);
        }
    }
}
