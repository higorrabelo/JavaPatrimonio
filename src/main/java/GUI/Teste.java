
package GUI;

import DAO.DAOFactory;
import DAO.Item_DAO;
import DAO.Usuarios_DAO;
import DB.DbException;
import Models.Item;
import Models.Usuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args){
        
        Usuarios_DAO userDAO = DAOFactory.criarUsuario();
        List<Usuarios> lista = new ArrayList<>();
        
        lista = userDAO.findAll();
        
        for(Usuarios user : lista){
            JOptionPane.showMessageDialog(null, user.toString());
        }
        
    }
}
