import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class KnockKnockClient {
    public static void main(String[] args) {
        try {
            System.out.println("Tentado se conectar a localhost:1234");
            Socket socket = new Socket("localhost", 1235);
            System.out.println("Conectado com sucesso a localhost:1234");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while ((userInput = stdin.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo:" + in.readLine());
                if (userInput.equalsIgnoreCase("/sair"))
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
