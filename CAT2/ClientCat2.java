/**
* <h1>This is the code for the client called ClientCat2 </h1> 

* @author  Group project led by Ashuza 
* @version 1.0 
*/
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  

public class ClientCat2 { 
   private ClientCat2 () {} 
   public static void main(String[] args) {  
      try { 
         /** Getting the registry */
         Registry registry = LocateRegistry.getRegistry(null); 
    
         /** Looking up the registry for the remote object */
         InterCat2 stub = (InterCat2) registry.lookup("InterCat2"); 
         
         /** Calling the remote method using the obtained object 
         */
		 stub.animation(); 
         
         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}