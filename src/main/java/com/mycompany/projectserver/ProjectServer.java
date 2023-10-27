import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProjectServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Server port is 5678");

        // Create a server socket listening on port 5678
        ServerSocket ss = new ServerSocket(5678);

        while (true) {
            // Accept incoming client connections
            Socket s = ss.accept();

            // Create a DataInputStream to receive data from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            try {
                // Read the data sent by the client as a UTF-encoded string
                String msg = dis.readUTF();
                System.out.println("Received data: " + msg);
            } catch (EOFException e) {
                // Handle the end of the stream (e.g., client disconnected)
                System.out.println("Client disconnected.");
            } catch (IOException e) {
                // Handle other IO errors
                e.printStackTrace();
            } finally {
                // Close the DataInputStream and the client socket
                dis.close();
                s.close();
            }
        }
    }
}
