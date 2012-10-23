// program can establish a connection to a server program using
// the Socket class and then,the client can send data to
// and receive data from the server through the socket.
//EchoClient, that connects to the Our server(Echo Server).
// The (our server) server simply receives data from its client(Andriod Name) and echoes it back. 
//that EchoClient both writes to and reads from its socket, thereby sending data to and receiving data from the Echo server.(hopefully it works).

//Echoclient wiil be replaced by Our Andoid Name or IP Addr(whatever)




import java.io.*;
import java.net.*;
 
public class EchoClient
 {
    public static void main(String[] args) throws IOException 
	{
 
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
		
		
 //The three statements in the try block of the main method are critical. These lines establish the socket connection between the client and the server and open a PrintWriter and a BufferedReader on the socket:
// The Socket constructor used here requires the name of the machine and the port number to which you want to connect. The example program uses the host name taranis(change to our host name). This is the name of a hypothetical machine on our local network.we need to change change the host name to the name of Our server machine on our network. we need Make sure that our name use is the fully qualified IP name of the machine to which you want to connect. The second argument is the port number. Port number 7 is the port on which the Echo server listens.(needs to be change to our port number).
        try {
            echoSocket = new Socket("taranis", 7);
			
//The second statement gets the socket's output stream and opens a PrintWriter on it. Similarly, the third statement gets the socket's input stream and opens a BufferedReader on it.I used readers and writers so that it can write Unicode characters over the socket.

//To send data through the socket to the server, EchoClient(our Adroid ) simply needs to write to the PrintWriter. To get the server's response, EchoClient reads from the BufferedReader. The rest of the program achieves this.

            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        }
		
		//Exceptions are thrown when connections fail
		catch (UnknownHostException e)
		{
            System.err.println("Don't know about host: taranis.");
            System.exit(1);
        } 
		catch (IOException e) 
		{
            System.err.println("Couldn't get I/O for "
                               + "the connection to: taranis.");
            System.exit(1);
        }
 
 
 //The loop reads a line at a time from the standard input stream and immediately sends it to the server by writing it to the PrintWriter connected to the socket:
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String userInput;
 
    while ((userInput = stdIn.readLine()) != null) {
        out.println(userInput);
        System.out.println("echo: " + in.readLine());
    }
 //The while loop continues until the an end-of-input character. That is, EchoClient reads input from the user, sends it to the Echo server, gets a response from the server, and displays it, until it reaches the end-of-input. The while loop then terminates and the program continues, executing the next four lines of code:
    out.close();
    in.close();
    stdIn.close();
    echoSocket.close();
    }
}

//Guys I spend the whole weekend researching how this will on iplementation,Please everybodies surgestions and input is highly recomanded,Hopefully it works or comes close to working.thanks frank Gadri