## Scenari comunicazione TCP - Server
1- Porta già in uso: BindException </br>
2- Porta non valida (fuori dall'intervallo 0-65535):	IllegalArgumentException </br>
3- Porta protetta che richiede permessi differenti: SecurityException </br>
4- Errori generici di connessione (vedi README.md del progetto Client): IOException	</br>
