package my.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

    public static void main(String[] args) throws IOException {
        int port = 1122;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Receiver listening on port " + port + "...");
        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            var stream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(stream)
            );
            String data = reader.readLine();
            System.out.println(data);
            stream.close();
        }

    }

}
