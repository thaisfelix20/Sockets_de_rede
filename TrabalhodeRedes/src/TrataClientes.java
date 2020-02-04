
import java.io.InputStream;//Biblioteca de entrada do cliente.
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
public class TrataClientes implements Runnable{
    private InputStream cliente;
    private servidor servidor;

    public TrataClientes(InputStream cliente, servidor servidor){
        this.cliente = cliente;//Vai receber os inputs cliente.
        this.servidor = servidor;//Vai receber o servidor.
    }

    public void run() {
        Scanner s = new Scanner(this.cliente);
        //Vai ser a variavel que guarda o que o cliente enviou.
        while(s.hasNextLine()) {
            System.out.println(s.nextLine());
            //Mostra o que o cliente enviou.
        }
        s.close();
    }
    
}
