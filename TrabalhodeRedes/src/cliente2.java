
import java.io.IOException;//Biblioteca relacionada as exceções de entrada e saida.
import java.io.PrintStream;//Biblioteca para o que o cliente enviou.
import java.net.Socket;//Biblioteca relacionada ao cliente.
import java.net.UnknownHostException;//Biblioteca relacionada a algum erro.
import java.util.Scanner;//Biblioteca relacionada a leitura de dados.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thaís Félix e Renan Cardoso
 */
public class cliente2 {

    private String host;
    private int porta;

    public cliente2(String host, int porta) {
        this.host = host;//Esse é o IP que ele está se conectando
        this.porta = porta;//Essa é a porta que ta se conectando
    }

    public void executa() throws UnknownHostException, IOException {
        try {
            Socket cliente = new Socket(this.host, this.porta);
            System.out.println("O cliente 2 se conectou!\n" + this.host);

            // lê msgs do teclado e manda pro servidor
            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            //O que o cliente esta enviando.

            String assunto;
            String mensagem = "";
            String resultado;

            System.out.println("Assunto: ");

            while (teclado.hasNextLine()) {
                assunto = teclado.nextLine(); //ler o assunto

                if (assunto.isEmpty()) {
                    assunto = "Assunto: Sem Assunto";
                    //se não for digitado um assunto, troca por "Sem Assunto".
                } else {
                    assunto = "Assunto: " + assunto;
                    //só formata.
                }

                do {
                    //Para obrigar o cliente digitar uma mensagem.
                    if (mensagem.equals("Sem Mensagem")) {
                        System.out.println("Digite uma Mensagem!\n");
                    }
                    System.out.println("Mensagem: ");
                    mensagem = teclado.nextLine();
                    if (mensagem.isEmpty()) {
                        mensagem = "Sem Mensagem";
                    } else {
                        mensagem = "Mensagem: " + mensagem;
                        //formata a mensagem
                    }
                } while (mensagem.equals("Sem Mensagem"));

                resultado = "Cliente 2\n" + assunto + "\n" + mensagem;
                //junta as duas partes assunto e mensagem

                saida.println(resultado);
                //Envia o assunto e a mensagem para o servidor.

                System.out.println("\nAssunto: ");
            }

            saida.close();
            teclado.close();
            cliente.close();
            
        } catch (IOException e) {
            //caso haja algum erro
            System.out.println("ERRO!!! " + e);
        }
    }

}
