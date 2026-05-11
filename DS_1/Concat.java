import java.rmi.*;

public interface Concat extends Remote {
    public String concat(String x, String y) throws RemoteException;
}


//2nd
// import java.rmi.*;
// import java.rmi.server.*;

// public class ConcatRemote extends UnicastRemoteObject implements Concat {
//     ConcatRemote() throws RemoteException {
//         super();
//     }

//     public String concat(String x, String y) {
//         return x + y;

//     }
// }



//3rd
// import java.util.*;
// import java.rmi.*;

// public class MyClient {
//     public static void main(String args[]) {
//         try {
//             Concat stub = (Concat) Naming.lookup("rmi://localhost/concat");
//             Scanner input = new Scanner(System.in);
//             String x, y;
//             System.out.println("Enter String 1:");
//             x = input.nextLine();
//             System.out.println("Enter String 2:");
//             y = input.nextLine();
//             System.out.println("Concatenated Result: " + stub.concat(x, y));
//         } catch (Exception e) {
//             System.out.println("Error: " + e);
//         }
//     }
// }


//4th
// import java.rmi.*;
// import java.rmi.registry.*;

// public class MyServer {
//     public static void main(String args[]) {
//         try {
//             LocateRegistry.createRegistry(1099); // start RMI registry from code
//             Concat stub = new ConcatRemote();
//             Naming.rebind("rmi://localhost/concat", stub);
//             System.out.println("Server ready and waiting...");
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }