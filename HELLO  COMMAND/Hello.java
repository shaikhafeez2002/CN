import java.util.*;
import java.io.*;
import java.net.*;

public class Hello{
       public static void main(String[] args) throws Exception
  {  
     InetAddress inet; // to get ipaddress of host
     String ip;
     ip = args[0];
     InetAddress ipb = InetAddress.getByName(ip); // getbynmae determines th ip address of a host.
     byte[] b = ipb.getAddress(); //returns raw ip address of InetAddress object
     inet = InetAddress.getByAddress(b); // getbyaddress retrusn inetaddress object created from raw ip address
     System.out.println("trying to connect");
    if(inet.isReachable(5000))
    {
         System.out.println("machine is working");
    }
    else
     {
             System.out.println("machine is not working");
     }
     
 }
}
     