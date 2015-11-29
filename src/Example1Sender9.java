import java.net.*;
import java.io.*;
//import java.long.*;
public class Example1Sender9 {
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
        int i=1;
        while(i==1)
        {
       
        mySocket.send(datagram);
        Thread.sleep(3000);
          
        }
        mySocket.close( );
       } // end try
      catch (Exception ex) {
        ex.printStackTrace( );
      }
    } // end else
  } // end main
} // end class
