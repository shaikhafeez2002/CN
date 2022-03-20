import java.net.*;
import java.io.*;
import java.util.*;

public class ServerUdp{

    public static void main(String [] args) throws Exception{
    
     DatagramSocket  ds = new DatagramSocket(3456);
     byte receiveByte[]= new byte[5000];
     byte sendByte[] = new byte[5000];
       
     while(true)
    {
      //receive 
        DatagramPacket receivePacket = new DatagramPacket(receiveByte,receiveByte.length);
        ds.receive(receivePacket);
 
        String receivestr = new String(receivePacket.getData());
        System.out.println("CLIENT: \n "+ receivestr);
    
        
  
        InetAddress ia1 =InetAddress.getLocalHost();
        
      //send
              
              DataInputStream din = new DataInputStream(System.in);
              String sendstr= din.readLine();
              sendByte = sendstr.getBytes();
              DatagramPacket sendpacket = new DatagramPacket(sendByte,sendByte.length,ia1,receivePacket.getPort());
              ds.send(sendpacket);

              
     }

    }

}