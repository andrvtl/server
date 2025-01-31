import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server(int porta){
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("1) Server in ascolto sulla porta" + porta);
        } catch (Exception e) {
            System.err.println("Errore del server nella fase di ascolto");
            throw new RuntimeException(e);
        }
    }

    public Socket attendi(){
        try {
            clientSocket= serverSocket.accept();
            System.out.println("2) Connessione avvenuta con successo, data socket creato.");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella connessione con il client");
        }
        return clientSocket;
    }

    public void invia(){

    }

    public void leggi(){

    }

    public void scrivi(){

    }
    
    public void chiudi(){
        try {
            clientSocket.close();
            System.out.println("5) Chiusura connessione avvenuta con successo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void termina(){

    }



}
