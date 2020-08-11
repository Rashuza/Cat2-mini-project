/**
* <h1>This is the code for the server called ServerCat2 </h1> 

* @author  Group project led by Ashuza 
* @version 1.0 
*/
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class ServerCat2 extends CAT2 { 
   public ServerCat2() {} 
   public static void main(String args[]) { 
      try { 
         /** Instantiating the implementation class */
         CAT2 obj = new CAT2();
      
         /** Exporting the object of implementation class  /
         *(here we are exporting the remote object to the stub) 
		  */
         InterCat2 stub = (InterCat2) UnicastRemoteObject.exportObject(obj, 0);  
      
         /** Binding the remote object (stub) in the registry */
         Registry registry = LocateRegistry.getRegistry(); 
         
         registry.bind("InterCat2", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}