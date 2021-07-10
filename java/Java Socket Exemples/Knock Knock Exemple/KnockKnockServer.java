import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class KnockKnockServer {
    public static void main(String[] args) {
        int port = 1235;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Esperando conexão do cliente...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado!");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Conexão estabelecida com sucesso!");

            String inputLine, outputLine;
            while ((inputLine = in.readLine()) != null) {
                outputLine = "";
                out.println(outputLine);
                if (outputLine.equalsIgnoreCase("/sair"))
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}