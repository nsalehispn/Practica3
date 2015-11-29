import java.net.*;
import java.io.*;
public class Example1Sender10 {
  public static void main(String[] args) {
    if (args.length != 3)
      System.out.println ("This program requires three command line arguments");
    else {
      
      
      try {
            
        InetAddress receiverHost = InetAddress.getByName(args[0]);
        int receiverPort = Integer.parseInt(args[1]);
        String message = args[2];
        // instantiates a datagram socket for sending the data
        DatagramSocket mySocket = new DatagramSocket();
        byte[ ] buffer = message.getBytes( );
        DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);
        mySocket.send(datagram);
  
        DatagramSocket mySocket1 = new DatagramSocket(12346);
        final int MAX_LEN = 10; 
        byte[ ] buffer1 = new byte[MAX_LEN];
        DatagramPacket datagram1= new DatagramPacket(buffer1, MAX_LEN);
        mySocket1.receive(datagram1);
        String message1 = new String(buffer1);
        System.out.println(message1);
        mySocket1.close( );
        mySocket.close( );
      } // end try
      catch (Exception ex) {
        ex.printStackTrace( );
      }
    } // end else
  } // end main
} // end class
