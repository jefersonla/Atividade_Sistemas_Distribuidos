package clientsockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest-7yheao
 */
public class ClientSocketsTCP {

    public static final String IP_SERVIDOR = "127.0.0.1"; 
    public static final int PORTA_SERVIDOR = 4567;
    
    public static void main(String[] args){
        try (Socket cliente = new Socket(IP_SERVIDOR, PORTA_SERVIDOR)) {
            System.out.println("Cliente conectado com servidor");
            
            System.out.print("Mensagem para enviar : ");            
            
            try (Scanner teclado = new Scanner(System.in); PrintStream saida_cliente = new PrintStream(cliente.getOutputStream())) {
                if(teclado.hasNextLine()){
                    saida_cliente.println(teclado.nextLine());
                }
                teclado.close();
                saida_cliente.close();
            }
            cliente.close();
            
            System.out.println("Conexão Fechada");
        } catch (IOException ex) {
            Logger.getLogger(ClientSocketsTCP.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro na conexão com o servidor");
        }
    }
    
}
