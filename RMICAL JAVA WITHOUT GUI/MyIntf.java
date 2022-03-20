import java.rmi.*;
public interface MyIntf extends Remote
{
    public double add(double d1,double d2) throws RemoteException;
    public double sub(double d1,double d2) throws RemoteException;
    public double mul(double d1,double d2) throws RemoteException;
    public double div(double d1,double d2) throws RemoteException;
    public double per(double d1,double d2) throws RemoteException;
     
}