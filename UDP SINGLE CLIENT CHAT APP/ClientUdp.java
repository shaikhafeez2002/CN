import java.net.*;
import java.io.*;
import java.util.*;

public class ClientUdp {

 public static void main(String[] args) throws Exception{
      
        DatagramSocket ds = new DatagramSocket();
        InetAddress ia =InetAddress.getLocalHost();
        byte sendByte[]=new byte[5000];
        byte receiveByte[] = new byte[5000]; 
  
        while(true)
       {
       
  
         //send 
          
          DataInputStream din = new DataInputStream(System.in);
          System.out.println("Client:");
          String sendstr = din.readLine(); 
          sendByte = sendstr.getBytes(); 
          DatagramPacket sendpacket = new DatagramPacket(sendByte,sendByte.length,ia,3456);
          ds.send(sendpacket);
         
      
         //receive
          
          DatagramPacket receivepacket = new DatagramPacket(receiveByte,receiveByte.length);
          ds.receive(receivepacket);
          String receivestr = new String(receivepacket.getData());
          System.out.println("SERVER: \n "+receivestr);
          

        


 }

 }

}







 
          
           

