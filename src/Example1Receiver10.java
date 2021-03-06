import java.net.*;
import java.io.*;
public class Example1Receiver10 {
  public static void main(String[] args) {
    if (args.length != 1)
      System.out.println("This program requires a command line argument.");
    else {
      int port = Integer.parseInt(args[0]);
      final int MAX_LEN = 10;
      // This is the assumed maximum byte length of the datagram to be received.
      try {
        DatagramSocket mySocket = new DatagramSocket(port);
        // instantiates a datagram socket for receiving the data
        byte[ ] buffer = new byte[MAX_LEN];
        DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
        mySocket.receive(datagram);
        String message = new String(buffer);
        System.out.println(message);
        
        InetAddress receiverHost1 = InetAddress.getByName("localhost");
        byte[ ] buffer1 = "OK,Recibio".getBytes( );
        DatagramSocket mySocket1 = new DatagramSocket();
        DatagramPacket datagram1 = new DatagramPacket(buffer1, buffer1.length, receiverHost1, 12346);
        mySocket1.send(datagram1);
        mySocket.close( );
        mySocket1.close( );
      } // end try
      catch (Exception ex) {
        ex.printStackTrace( );
      }
    } // end else
  } // end main
} // end class
