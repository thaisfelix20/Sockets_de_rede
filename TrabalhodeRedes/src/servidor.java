
import java.io.IOException;//Biblioteca relacionada as exceções de entrada e saida.
import java.io.PrintStream;//Bibiblioteca para o que foi digitado pelo cliente.
import java.net.ServerSocket;//Biblioteca relacionada ao servidor.
import java.net.Socket;//Biblioteca relacionada ao cliente.
import java.util.ArrayList;//Biblioteca para a lista de clientes.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thaís Félix e Renan Cardoso
 */
public class servidor {

    private int porta;
    private ArrayList<PrintStream> clientes;

    public servidor(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();
    }

    public void executa() throws IOException {
        // abertura de porta
        try {
            ServerSocket servidor = new ServerSocket(this.porta);
            System.out.println("Servidor Iniciado!");
            System.out.println("Porta " + this.porta + " aberta!");
            System.out.println("Caso queira finalizar aperte CTRL+C.");

            while (true) {
                // aceita cliente e imprime cliente conectado
                Socket cliente = servidor.accept();
                System.out.println("Nova conexão com cliente "
                        + cliente.getInetAddress().getHostAddress());

                // adiciona saida do cliente a lista
                PrintStream ps = new PrintStream(cliente.getOutputStream());
                this.clientes.add(ps);

                // cria tratador de cliente numa nova thread
                TrataClientes tc = new TrataClientes(cliente.getInputStream(), this);
                new Thread(tc).start();

            }
        } catch (IOException e) {
            //caso haja algum erro
            System.out.println("ERRO!!! " + e);
        }
    }

}
