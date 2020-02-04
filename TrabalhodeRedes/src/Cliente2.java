
import java.io.IOException;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thais
 */
public class Cliente2 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // dispara cliente
        new cliente2("127.0.0.1", 50000).executa();
}
}