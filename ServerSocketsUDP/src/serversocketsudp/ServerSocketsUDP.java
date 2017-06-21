package serversocketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocketsUDP {
    
    public final static int PORTA_SERVIDOR = 4567;
    public final static int MAX_SIZE_MESSAGE = 1024;
    
    public static void main(String[] args) {
        DatagramSocket servidor;
        
        try {
            servidor = new DatagramSocket(PORTA_SERVIDOR);
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketsUDP.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Nao foi possivel criar o servidor com a porta " + PORTA_SERVIDOR);
            return;
        }
        
        System.out.println("Servidor criado com sucesso");
        
        while(true){            
            try {
                byte[] client_data = new byte[MAX_SIZE_MESSAGE];
                DatagramPacket msg_received = new DatagramPacket(client_data, MAX_SIZE_MESSAGE);
                servidor.receive(msg_received);
                
                System.out.println("Conexao feita com " + msg_received.getAddress());
                String mensagem_recebida = new String(msg_received.getData());
                System.out.println("Mensagem Recebida : " + mensagem_recebida);
                
                System.out.println("\nFim da mensagem do cliente " + msg_received.getAddress());
            } catch (IOException ex) {
                Logger.getLogger(ServerSocketsUDP.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Erro na comunicação");
            }
        }
    }
    
}
