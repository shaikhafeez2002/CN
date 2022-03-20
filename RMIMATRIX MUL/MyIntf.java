import java.rmi.*;
public interface MyIntf extends Remote
{
   	public int[][] mul(int A[][],int B[][],int row1,int col1,int col2) throws RemoteException;
}