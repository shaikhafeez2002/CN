import java.util.*;
import java.io.*;
import java.net.*;

public class EchoClient{
      public static void main(String[] args) throws Exception
{
      String str;  
      long t1,t2;
      Socket s= new Socket(); // creating a clientsocket
      String ip = args[0];
 
      try{
           s.connect(new InetSocketAddress(ip,5000)); // creates a socket address from a hostname and a port number
           System.out.println("connected");
         }

      catch(Exception e)
       {
         System.out.println(e);
        }
 
  DataInputStream din= new DataInputStream(s.getInputStream());
  PrintStream out  = new PrintStream(s.getOutputStream());

  t1=System.currentTimeMillis();
  str = "Hello";

  out.println(str);

  System.out.println(din.readLine());

  t2= System.currentTimeMillis();
  System.out.println("RTT ="+(t2-t1) + "ms");

  s.close();
}

}
     