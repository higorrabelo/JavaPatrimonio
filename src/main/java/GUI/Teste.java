
package GUI;

import Models.Item;
import Models.Usuarios;
import javax.swing.JOptionPane;
public class Teste {
    public static void main(String[] args){
        Usuarios user = new Usuarios();
        Item it = new Item(4,"Teclado","Multilaser",10,"Americanas","Doca");
        user.setId(3);
        user.setNome("Higor");
        user.setEmail("higor.rabelo@gmail.com");
        user.setSenha("Higor20");
        String us = user.toString();
        String its = it.toString();
        JOptionPane.showMessageDialog(null,us);
        JOptionPane.showMessageDialog(null,its);
    }
}
