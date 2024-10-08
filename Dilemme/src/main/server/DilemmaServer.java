import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class DilemmaServer {
    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> clients;

    public DilemmaServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket);
                clients.add(client);
                client.start();
            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                System.out.println("Error creating client handler: " + e.getMessage());
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message from client: " + message);
                    if (message.startsWith("DECISION")) {
                        // Handle client decision
                        String decision = message.substring(9);
                        System.out.println("Client decision: " + decision);
                        // Update game state and scores
                        // Send updated game state and scores to client
                        out.println("GAME_STATE " + getGameState());
                    } else if (message.startsWith("ABANDON")) {
                        System.out.println("Client abandoned game"); //Abonnement du jeu
                        out.println("GAME_STATE " + getGameState());
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error closing client socket: " + e.getMessage());
                }
            }
        }

        private String getGameState() {
            return "SCORES 0 0"; //A modifier pour donner le vrai resultat
        }
    }

    public static void main(String[] args) {
        DilemmaServer server = new DilemmaServer(8000);
        server.start();
    }
}