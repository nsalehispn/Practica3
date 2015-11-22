import java.net.*;
import java.io.*;
public class Example1Sender7 {
  public static void main(String[] args) {
    if (args.length != 4)
      System.out.println ("This program requires three command line arguments");
    else {
      try {
        InetAddress receiverHost = InetAddress.getByName(args[0]);
        int receiverPort1 = Integer.parseInt(args[1]);
        int receiverPort2 = Integer.parseInt(args[2]);

        String message = args[3];
        // instantiates a datagram socket for sending the data
        DatagramSocket mySocket = new DatagramSocket();
        byte[ ] buffer = message.getBytes( );
        DatagramPacket datagram1 = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort1);
        DatagramPacket datagram2 = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort2);

        mySocket.send(datagram1);
        mySocket.send(datagram2);

        mySocket.close( );
      } // end try
      catch (Exception ex) {
        ex.printStackTrace( );
      }
    } // end else
  } // end main
} // end class
