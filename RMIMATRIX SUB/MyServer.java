import java.rmi.*;
import java.rmi.server.*;

public class MyServer{
    public static void main(String[] args) throws Exception{
	 MyImpl obj= new MyImpl();
	 Naming.rebind("SUB",obj);
     System.out.println("Server started");
	 }
}