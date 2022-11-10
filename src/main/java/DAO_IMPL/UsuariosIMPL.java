
package DAO_IMPL;

import DAO.Usuarios_DAO;
import DB.Db;
import DB.DbException;
import Models.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuariosIMPL implements Usuarios_DAO{

    private Connection conn = null;
    
    public UsuariosIMPL(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Usuarios user) {
        String sql = "insert into usuarios(nome,email,senha) values (?,?,md5(?))";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,user.getNome().toUpperCase());
            st.setString(2, user.getEmail().toUpperCase());
            st.setString(3, user.getSenha().toUpperCase());
            int rows = st.executeUpdate();
            if(rows!=0){
                JOptionPane.showMessageDialog(null, "Usuário Inserido com Sucesso");
            }
        }
        catch(SQLException e){
            throw new DbException("Erro ao Adicionar Usuario ao Banco");
        }
    }

    @Override
    public void update(Usuarios user) {
        String sql = "update usuarios set nome = ?, email = ?, senha = md5(?) where id = ?";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,user.getNome().toUpperCase());
            st.setString(2, user.getEmail().toUpperCase());
            st.setString(3, user.getSenha().toUpperCase());
            st.setInt(4, user.getId());
            
            int rows = st.executeUpdate();
            if(rows!=0){
                JOptionPane.showMessageDialog(null,"Usuário Atualizado com Sucesso");
            }
        }
        catch(SQLException e){
            throw new DbException("Usuário atualizado com sucesso \n"+e.getMessage());
        }
    }

    @Override
    public void delete(Usuarios user) {
        PreparedStatement st = null;
        String sql = "delete from usuarios where id = ?";
        try{
            st = conn.prepareStatement(sql);
            st.setInt(1, user.getId());
            int rows = st.executeUpdate();
            if(rows!=0){
                JOptionPane.showMessageDialog(null,"Usuário removido com sucesso");
            }
        }
        catch(SQLException e){
            throw new DbException("Erro ao Excluir usuário");
        }
    }

    @Override
    public Usuarios findOne(Usuarios user) {
       PreparedStatement st = null;
       String sql = "select * from usuarios where id = ?";
       Usuarios us = null;
       try{
           st = conn.prepareStatement(sql);
           st.setInt(1, user.getId());
           ResultSet rs = st.executeQuery();
           while(rs.next()){
               us = new Usuarios(
                       rs.getInt("id"),
                       rs.getString("nome"),
                       rs.getString("email"),
                       rs.getString("senha")
               );
           }
           return us;
       }
       catch(SQLException e){
           throw new DbException("Usuário não encontrado \n"+e.getMessage());
       }
    }

    @Override
    public List<Usuarios> findAll() {
        List lista = new ArrayList<>();
        PreparedStatement st = null;
        String sql = "select * from usuarios";
        try{
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Usuarios user = new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                lista.add(user);
            }
            return lista;
        }
        catch(SQLException e){
            throw new DbException("Erro ao Listar Usuários\n " + e.getMessage());
        }
    }
    
}
