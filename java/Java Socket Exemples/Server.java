import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class Server {
    public static void main(String[] args) {
        ArrayList<ServerThread> threads = new ArrayList<ServerThread>();
        int port = 1235;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Esperando nova conexão com clientes...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado! Criando thread para manuseá-lo");
                ServerThread newThread = new ServerThread(clientSocket);
                newThread.start();
                threads.add(newThread);   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ServerThread extends Thread {
        PrintWriter out;
        BufferedReader in;
        Socket clientConnection;
        boolean running = false;
        ServerThread(Socket connection) throws IOException {
            this.clientConnection = connection;
            this.in = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
            this.out = new PrintWriter(clientConnection.getOutputStream(), true);
        }

        @Override
        public void run() {
            running = true;
            String inputLine, outputLine;
            try {
                // in.readLine()) recebe linha da conexão
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Recebido:\"" + inputLine + "\" do Cliente");
                    outputLine = "Recebido:" + inputLine;
                    out.println(outputLine);// Envia linha ao cliente
                    System.out.println("Retornado :\"" + outputLine + "\" para o Cliente");
                    if (outputLine.equalsIgnoreCase("/sair"))
                        System.out.println("Cliente desconectado.");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
