import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    InputStream is;
    Scanner streamIn = null;
    OutputStream os;
    PrintWriter streamOut = null;
    String messaggioIn, messaggioOut;

    public Server(int porta){

        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("1) Server in ascolto sulla porta "+porta);
        } catch (BindException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore, porta già occupata");
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore, porta non esistente");
        }catch (SecurityException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore, la porta è protetta, non si hanno i permessi per accedere");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore del server nella fase di ascolto");
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
        try {
            is = clientSocket.getInputStream();
            streamIn = new Scanner(is);
            System.out.println("Leggo il messaggio del client");
            messaggioIn = streamIn.nextLine();
            System.out.println("Messaggio del client: " + messaggioIn);

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nell'inizializzazione dello stream di input");
        }
    }

    public void scrivi(){
        try {
            os = clientSocket.getOutputStream();
            streamOut = new PrintWriter(os);

            System.out.println("Spedisco il messaggio al client");
            messaggioOut="Ciao client! Ti aspettavo";
            streamOut.println(messaggioOut);
            streamOut.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nell'inizializzazione dello stream di output");
        }
    }
    
    public void chiudi(){
        try {
            clientSocket.close();
            System.out.println("5) Chiusura connessione avvenuta con successo");
        } catch (IOException e) {
            System.err.println("Errore nella chiusura del clientSocket");
        }
    }

    public void termina(){
        if(serverSocket != null){
            try {
                serverSocket.close();
                System.out.println("6) Chiusura del DataSocket (server) avvenuta con successo, il server non accetta più connessioni");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura della serverSocket");
            }
        }else{
            System.out.println("La serverSocket non può essere chiusa perchè non è stata istanziata");
        }
    }



}
