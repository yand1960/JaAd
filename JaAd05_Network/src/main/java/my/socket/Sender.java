package my.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Sender {

    public static void main(String[] args) throws IOException {

        String ip = "127.0.0.1";
        int port = 1122;
        Socket socket = new Socket(ip,port);
        String data  = "Hello from tcpip sender!\n";
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );
        writer.write(data);
        writer.close();
        socket.close();
    }

}
