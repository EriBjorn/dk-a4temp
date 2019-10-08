package no.ntnu.datakomm;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A Simple TCP client, used as a warm-up exercise for assignment A4.
 */
public class SimpleTcpServer {
    
    private ServerSocket welcomeSocket;
    
    private static final int PORT = 1234; 
    
    public static void main(String[] args) {
        SimpleTcpServer server = new SimpleTcpServer();
        log("Simple TCP server starting");
        server.run();
        log("ERROR: the server should never go out of the run() method! After handling one client");
    }

    public void run() 
    {
        boolean running = true;

        while(running)
                {
        try
        {
        welcomeSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);
        Socket clientSocket = welcomeSocket.accept();
        
        
        InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bufReader = new BufferedReader(reader);
        
        
        String clientInput = bufReader.readLine();
        
            System.out.println("Client sent: " + clientInput);
            
            String response = clientInput;

        
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(response);
            
            
            
        
        //Close connection to this particular client
        welcomeSocket.close();
        
        //Close the listening socket, allow other services to listen on this TCP port
        welcomeSocket.close();
        
        
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
                }
        
        // TODO - implement the logic of the server, according to the protocol.
        // Take a look at the tutorial to understand the basic blocks: creating a listening socket,
        // accepting the next client connection, sending and receiving messages and closing the connection
    }

    /**
     * Log a message to the system console.
     *
     * @param message The message to be logged (printed).
     */
    private static void log(String message) {
        System.out.println(message);
    }
}
