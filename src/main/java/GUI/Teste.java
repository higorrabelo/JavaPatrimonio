
package GUI;

import DAO.DAOFactory;
import DAO.Item_DAO;
import DB.DbException;
import Models.Item;
import Models.Usuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args){
        Item_DAO itemDao = DAOFactory.criarItem();
        
        
        Item it = new Item(3,"Monitor","Samsumg",20,"Amazon","Unidade Doca");
        
        itemDao.update(it);
        
        List<Item> lista = new ArrayList<>();
        try{
            lista  = itemDao.findAll();
            for(Item item : lista){
                JOptionPane.showMessageDialog(null, item.toString());
            }
        }
        catch(Exception e){
            throw new DbException("Erro em executar a função \n"+e.getMessage());
        }
    }
}
