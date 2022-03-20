import java.rmi.*;
import java.util.*;
public class MyClient{
public static void main(String[] args) throws Exception
{
     Scanner sc= new Scanner(System.in);
     int run;
     do{
           System.out.println("\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Percentage\n6.EXIT");
           System.out.println("enter your choice");
           int choice= sc.nextInt();
           if(choice == 6)
           {
                break;
           }
           System.out.println("enter first number");
           double n1 = sc.nextDouble();
           System.out.println("enter second number");
           double  n2 = sc.nextDouble();
           double n;
           switch(choice){
           case 1:
                 MyIntf obj1 = (MyIntf)Naming.lookup("ADD");
                 n =obj1.add(n1,n2);
                 System.out.println("Addition = "+n);
                 break;
          case 2:
                 MyIntf obj2 = (MyIntf)Naming.lookup("ADD");
                 n = obj2.sub(n1,n2);
                 System.out.println("SUBTRACTION = "+n);
                 break;
          case 3:
                 MyIntf obj3 = (MyIntf)Naming.lookup("ADD");
                 n = obj3.mul(n1,n2);
                 System.out.println("MULTIPLICATION = "+n);
                 break;
          case 4:
                 MyIntf obj4 = (MyIntf)Naming.lookup("ADD");
                 n = obj4.div(n1,n2);
                 System.out.println("DIVISION = "+n);
                 break;
          case 5:
                 MyIntf obj5 = (MyIntf)Naming.lookup("ADD");
                 n = obj5.per(n1,n2);
                 System.out.println("PERCENTAGE = "+n);
                 break;
          }
        System.out.println("PRESS 1 TO RUN AGAIN OR 0 to exit");
        run =sc.nextInt();
        }while(run == 1);
   }
}


 

                 
               
                 
           
            