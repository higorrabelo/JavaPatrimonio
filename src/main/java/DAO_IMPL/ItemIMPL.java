
package DAO_IMPL;

import DAO.Item_DAO;
import DB.DbException;
import Models.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ItemIMPL implements Item_DAO{
    
    private Connection conn = null;
    
    public ItemIMPL(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Item item) {
        String sql = "insert into item(nome,fabricante,quantidade,fornecedor,armazem)"
                     + " values (?,?,?,?,?) ";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,item.getNome().toUpperCase());
            st.setString(2, item.getFabricante().toUpperCase());
            st.setInt(3, item.getQuantidade());
            st.setString(4, item.getFornecedor().toUpperCase());
            st.setString(5, item.getArmazem().toUpperCase());
           int rows = st.executeUpdate();
           
           if(rows!=0){
               JOptionPane.showMessageDialog(null, "Item adicionado com sucesso");
           }
        }
        catch(SQLException e){
            throw new DbException("Erro ao Inserir no Banco de Dados: \n"+e.getMessage());
        }
    }

    @Override
    public void update(Item item) {
        String sql = "update item set nome = ?, fabricante = ? , quantidade = ?, fornecedor = ? , armazem = ? where id_patrimonio = ?";
        PreparedStatement st = null;
        try{
            st=conn.prepareStatement(sql);
            st.setString(1, item.getNome());
            st.setString(2, item.getFabricante().toUpperCase());
            st.setInt(3, item.getQuantidade());
            st.setString(4, item.getFornecedor().toUpperCase());
            st.setString(5, item.getArmazem().toUpperCase());
            st.setInt(6, item.getId());
            int rows = st.executeUpdate();
            if(rows!=0){
                JOptionPane.showMessageDialog(null, "Item Atualizado com sucesso!!!");
            }
        }
        catch(SQLException e){
            throw new DbException("Erro em Atualizar o item \n"+e.getMessage());
        }
    }

    @Override
    public void delete(Item item) {
        String sql = "delete from item where id_patrimonio = ?";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setInt(1, item.getId());
            int rows = st.executeUpdate();
            if(rows!=0){
                JOptionPane.showMessageDialog(null, "Item Removido com sucesso");
            }
        }
        catch(SQLException e){
            throw new DbException("Erro ao Deletar Item \n"+e.getMessage());
        }
    }

    @Override
    public Item findOne(Item item) {
        String sql ="select * from item where id_patrimonio = ?";
        PreparedStatement st = null;
        try{
            Item it=null;
            st = conn.prepareStatement(sql);
            st.setInt(1, item.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               it = new Item(
                       rs.getString("id_patrimonio"),
                       rs.getString("fabricante"),
                       rs.getInt("quantidade"),
                       rs.getString("fornecedor"),
                       rs.getString("armazem")
               );
            }
            return it;
        }
        catch(SQLException e){
            throw new DbException("Erro ao Selecionar usuário \n" + e.getMessage());
        }
    }

    @Override
    public List<Item> findAll() {
        String sql = "select * from item";
        PreparedStatement st = null;
        List<Item> lista = new ArrayList<Item>();
        try{
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Item item = new Item(
                        rs.getInt("id_patrimonio"),
                        rs.getString("nome"),
                        rs.getString("fabricante"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("armazem")
                );
                lista.add(item);
            }
            
            return lista;
        }
        catch(SQLException e){
            throw new DbException("Erro ao retornar lista de Itens \n"+ e.getMessage());
        }
    }
    
}
