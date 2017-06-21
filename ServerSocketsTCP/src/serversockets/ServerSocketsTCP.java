/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest-7yheao
 */
public class ServerSocketsTCP {

    public final static int PORTA_SERVIDOR = 4567;
    
    public static void main(String[] args) {
        ServerSocket servidor;
        
        try {
            servidor = new ServerSocket(PORTA_SERVIDOR);
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketsTCP.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Nao foi possivel criar o servidor com a porta " + PORTA_SERVIDOR);
            return;
        }
        
        System.out.println("Servidor criado com sucesso");
        
        while(true){
            try (Socket cliente = servidor.accept()) {
                System.out.println("Conexao feita com " + cliente.getInetAddress());
                try (Scanner scanner_cliente = new Scanner(cliente.getInputStream())) {
                    System.out.print("Mensagem : ");
                    while(scanner_cliente.hasNextLine()){
                        System.out.print(scanner_cliente.nextLine());
                    }
                    System.out.println("\nFim da mensagem do cliente " + cliente.getInetAddress());
                    scanner_cliente.close();
                }
                cliente.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerSocketsTCP.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Erro na comunicação");
            }
        }
    }
}
