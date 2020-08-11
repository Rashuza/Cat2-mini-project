/**
* <h1>This is the code for the interface called InterCat2 </h1> 

* @author  Group project led by Ashuza 
* @version 1.0 
*/
import java.rmi.Remote; 
import java.rmi.RemoteException;  

/** Creating Remote interface for our application
*/ 
public interface InterCat2 extends Remote { 
    void Registration()throws RemoteException;  
}