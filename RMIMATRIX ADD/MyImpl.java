import java.rmi.*;
import java.rmi.server.*;
public class MyImpl extends UnicastRemoteObject implements
MyIntf{
   public MyImpl() throws Exception
   {
    super();
	}

	public  int[][] add(int A[][],int B[][],int row,int col)throws RemoteException{
	  int i, j;
        int C[][] = new int[row][col];
 
        for (i = 0; i < row; i++)
            for (j = 0; j < col; j++)
                C[i][j] = A[i][j] + B[i][j];
 
        return C;
	}
}