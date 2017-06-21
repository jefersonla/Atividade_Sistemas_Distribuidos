package clientsocketsudp;

import java.io.PrintStream;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class ClientSocketsUDP {

    public final static int PORTA_SERVIDOR = 4567;
    
    public static void main(String[] args) {
        try (DatagramSocket msg_recebida = new DatagramSocket(PORTA_SERVIDOR)) {
            System.out.println("Cliente conectado com servidor");
            
            System.out.print("Mensagem para enviar : ");            
            
            try (Scanner teclado = new Scanner(System.in)) {
                if(teclado.hasNextLine()){
                    saida_cliente.println(teclado.nextLine());
                }
                
                teclado.close();
            }
        }
        catch(SocketException e){
            
        }
        System.out.println("Conexão Fechada");
    }
    
}
