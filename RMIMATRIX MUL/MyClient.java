import java.rmi.*;
import java.util.*;
public class MyClient{
 public static void main(String[] args) throws Exception
 {
    Scanner in = new Scanner(System.in);
	int run;
	do
	{
	  int row1, col1,i,j,row2,col2;
	  
      
      System.out.println("Enter the number of rows of matrix1");
      row1 = in.nextInt();
 
      System.out.println("Enter the number columns of matrix1");
      col1 = in.nextInt();
     
      System.out.println("Enter the number of rows of matrix2");
      row2 = in.nextInt();
  
     System.out.println("Enter the number columns of matrix2");
      col2 = in.nextInt();
   
      if(col1!=row2){
         System.out.println("not possible");
      }
    
     else{
 
      int mat1[][] = new int[row1][col1];
     
     System.out.println("Enter the elements of matrix1");
 
       for ( i= 0 ; i < row1 ; i++ )
       { 
 
          for ( j= 0 ; j < col1 ;j++ )
		   {
           mat1[i][j] = in.nextInt();
           }
           System.out.println();
		   
        }
    

     int mat2[][] = new int[row2][col2];

     System.out.println("Enter the elements of matrix2");
 
     for ( i= 0 ; i < row2 ; i++ )
     {
      for ( j= 0 ; j < col2 ;j++ ){
       mat2[i][j] = in.nextInt();
       }
       System.out.println();
	   
     }
  
	
	int n[][] = new int[row1][col2];

	MyIntf obj1= (MyIntf)Naming.lookup("MUL");
	n=obj1.mul(mat1,mat2,row1,col1,col2);
	for(i=0;i<row1;i++)
       {
          for(j=0;j<col2;j++)
         {
             System.out.print(n[i][j]+" ");
         }
          System.out.println();
      }
     }
     System.out.println("press 1 to run and 0 to exit");
     run =in.nextInt();

  }while(run == 1);
 }
}