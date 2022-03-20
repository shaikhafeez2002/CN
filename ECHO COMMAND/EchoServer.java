import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer
{
 public static void main(String args[]) throws Exception
 {
  ServerSocket ss=new ServerSocket(5000); //creating serversocket
  Socket s=ss.accept();
  DataInputStream din=new DataInputStream(s.getInputStream());
  PrintStream out=new PrintStream(s.getOutputStream());
  String str=din.readLine();
  System.out.println("reply :"+InetAddress.getLocalHost()+"length :"+str.length());
  s.close();
  ss.close();
 }
}