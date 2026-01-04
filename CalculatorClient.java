import java.rmi.*;

public class CalculatorClient {
    public static void main(String[] args) {
        
        try {
            String url = "rmi://localhost/CalculatorService";
            CalculatorInterface remoteObject = (CalculatorInterface)Naming.lookup(url);
            
            System.out.println("Got remote object");
            System.out.println("10 + 20 = " + remoteObject.add(10, 20));
            System.out.println("10 - 5 = " + remoteObject.subtract(10, 5));
            System.out.println("10 * 5 = " + remoteObject.multiply(10, 5));
            System.out.println("10 / 2 = " + remoteObject.divide(10, 2));
            
        } catch (RemoteException exc) {
            System.out.println("Error in lookup: " + exc.toString());
        } catch (java.net.MalformedURLException exc) {
            System.out.println("Malformed URL: " + exc.toString());
        } catch (java.rmi.NotBoundException exc) {
            System.out.println("NotBound: " + exc.toString());
        }
    }
}