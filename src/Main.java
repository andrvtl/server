import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Server s= new Server(2000);

        // Variabili per definire il numero di client che richiederanno la connessione, scelta in input dall'utente
        int numero = 0;
        int i = 0;

        System.out.println("Quanti client richiederanno la connessione? ");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );


        try {
            numero = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println("Errore nell'inserimento del numero ");
        }

        // Ciclo che effettua e chiude la connessione per ogni client determinato
        while(i<numero){

            System.out.println("\n");
            System.out.println("Client num."+i);

            s.attendi();
            s.chiudi();
            i++;
        }

        // Finito il ciclo di connessioni predeterminate chiude la server socket
        System.out.println("\n");
        s.termina();
    }

}
