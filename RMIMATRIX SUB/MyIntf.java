import java.rmi.*;
public interface MyIntf extends Remote
{
   	public int[][] sub(int A[][],int B[][],int row,int col) throws RemoteException;
}