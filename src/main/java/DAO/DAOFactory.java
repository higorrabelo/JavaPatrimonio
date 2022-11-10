package DAO;
import DAO_IMPL.ItemIMPL;
import DAO_IMPL.UsuariosIMPL;
import DB.Db;

public class DAOFactory {
    
    public static Usuarios_DAO criarUsuario(){
        return new UsuariosIMPL(Db.getConnection());
    }
    public static Item_DAO criarItem(){
        return new ItemIMPL(Db.getConnection());
    }
    
}
