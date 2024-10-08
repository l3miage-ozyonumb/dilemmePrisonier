import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DilemmaClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public DilemmaClient(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected to server");
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }

    public void sendDecision(String decision) {
        out.println("DECISION " + decision);
    }

    public void receiveGameState() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received message from server: " + message);
                if (message.startsWith("GAME_STATE")) {
                    // Handle game state and scores
                    String gameState = message.substring(10);
                    System.out.println("Game state: " + gameState);
                }
            }
        } catch (IOException e) {
            System.out.println("Error receiving game state: " + e.getMessage());
        }
    }

    public void abandonGame() {
        out.println("ABANDON");
    }

    public static void main(String[] args) {
        DilemmaClient client = new DilemmaClient("localhost", 8000);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter decision (COOPERATE or DEFECT): ");
            String decision = scanner.nextLine();
            client.sendDecision(decision);
            client.receiveGameState();
        }
    }
}