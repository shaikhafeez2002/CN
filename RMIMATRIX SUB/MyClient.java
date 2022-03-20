import java.rmi.*;
import java.util.*;
public class MyClient{
 public static void main(String[] args) throws Exception
 {
    Scanner in = new Scanner(System.in);
	int run;
	do
	{
	  int row, col,i,j;
	  
    
      System.out.println("Enter the number of rows");
      row = in.nextInt();
 
      System.out.println("Enter the number columns");
      col = in.nextInt();
 
      int mat1[][] = new int[row][col];
      int mat2[][] = new int[row][col];
      
 
      System.out.println("Enter the elements of matrix1");
 
       for ( i= 0 ; i < row ; i++ )
       { 
 
          for ( j= 0 ; j < col ;j++ )
		   {
           mat1[i][j] = in.nextInt();
           }
           System.out.println();
		   
        }
  
     System.out.println("Enter the elements of matrix2");
 
     for ( i= 0 ; i < row ; i++ )
     {
      for ( j= 0 ; j < col ;j++ ){
       mat2[i][j] = in.nextInt();
       }
       System.out.println();
	   
     }
  
	
	int n[][] = new int[row][col];

	MyIntf obj1= (MyIntf)Naming.lookup("SUB");
	n=obj1.sub(mat1,mat2,row,col);
	for(i=0;i<row;i++)
       {
          for(j=0;j<col;j++)
         {
             System.out.print(n[i][j]+" ");
         }
          System.out.println();
      }

     System.out.println("press 1 to run and 0 to exit");
     run =in.nextInt();
	
  }while(run == 1);
 }
}