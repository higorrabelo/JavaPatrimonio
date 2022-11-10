
package DAO_IMPL;

import DAO.Usuarios_DAO;
import DB.Db;
import DB.DbException;
import Models.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UsuariosIMPL implements Usuarios_DAO{

    private Connection conn = null;
    
    public UsuariosIMPL(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Usuarios user) {
        String sql = "insert into usuarios(nome,email,senha) values (?,?,?)";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,user.getNome());
            
            
        }
        catch(SQLException e){
            throw new DbException("Erro ao Adicionar Usuario ao Banco");
        }
    }

    @Override
    public void update(Usuarios user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuarios user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarios findOne(Usuarios user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuarios> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
