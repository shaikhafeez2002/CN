import java.rmi.*;
import java.rmi.server.*;
public class MyImpl extends UnicastRemoteObject implements
MyIntf{
   public MyImpl() throws Exception
   {
    super();
	}

	public  int[][] mul(int A[][],int B[][],int row1,int col1,int col2)throws RemoteException{
	  int i,j,k;
        int C[][] = new int[row1][col2];
 
        for (i = 0; i < row1; i++)
            for (j = 0; j < col2; j++){
                  C[i][j]=0;
                for(k=0;k<col1;k++)
                  C[i][j] += A[i][k] * B[k][j];
                }
        return C;
	}
}