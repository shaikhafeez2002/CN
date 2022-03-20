import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
public class MyImpl extends UnicastRemoteObject implements MyIntf
{
     public MyImpl() throws Exception
	{
	   super();
	}
	
	public double add(double d1,double d2) throws RemoteException
	{
		
	   return d1+d2;
	}
     public double sub(double d1,double d2) throws RemoteException
	{
		
	   return d1-d2;
	}  
     public double mul(double d1,double d2) throws RemoteException
	{
		
	   return d1*d2;
	}  
     public double div(double d1,double d2) throws RemoteException
	{
		
	   return d1/d2;
	}
      public double per(double d1,double d2) throws RemoteException
	{
		
	   return (d1/d2)*100;
	}
}     
      