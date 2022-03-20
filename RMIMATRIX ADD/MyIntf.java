import java.rmi.*;
public interface MyIntf extends Remote
{
   	public int[][] add(int A[][],int B[][],int row,int col) throws RemoteException;
}