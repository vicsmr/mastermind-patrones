package santaTecla.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIP {

    private ServerSocket serverSocket;

    private Socket socket;

    private PrintWriter out;

    private BufferedReader in;

    public TCPIP(Socket socket) {
        this.serverSocket = null;
        this.socket = socket;
        try {
            this.out = new PrintWriter(socket.getOutputStream());
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public TCPIP(ServerSocket serverSocket, Socket socket) {
        this(socket);
        this.serverSocket = serverSocket;
    }


    public void send(String value) {
        this.out.println(value);
        this.out.flush();
    }

    public void send(int value) {
        this.send("" + value);
    }

    public void send(boolean value) {
        this.send("" + value);
    }

    public String receiveLine() {
        String result = null;
        try {
            result = this.in.readLine();
        } catch (IOException e) {
            System.out.println("Error en servidor!!! Lectura de string");
        }
        return result;
    }

    public boolean receiveBoolean() {
        boolean result = false;
        try {
            result = Boolean.parseBoolean(this.in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int receiveInt() {
        int result = -1;
        try {
            result = Integer.parseInt(this.in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() {
        try {
            this.in.close();
            this.out.close();
            this.socket.close();
            if (this.serverSocket != null) {
                this.serverSocket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
