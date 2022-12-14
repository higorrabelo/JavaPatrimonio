package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Db{
    
    private static Connection conn = null; 
    
    public static Connection getConnection(){
        try{
            Properties props = loadProperties();
            String url = props.getProperty("dburl");
            conn = DriverManager.getConnection(url,props);
        }
        catch(SQLException e){
            throw new DbException("Erro em Conectar ao Banco de Dados");
        }
        return conn;
    }
    
    public void closeConnection(){
       if(conn!=null){
        try{
            conn.close();
        }
        catch(SQLException e){
            throw new DbException("Não fora possível fechar a conexão");
        }
       }
    }
    public void closeStatement(Statement st){
        if(st!=null){
            try{
                st.close();
            }
            catch(SQLException e){
                throw new DbException("Erro em fechar a Sentença SQL");
            }
        }
    }
    public void closeResultSet(ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }
            catch(SQLException e){
                throw new DbException("Erro ao Fechar as Buscas SQL");
            }
        }
    }

    public static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("banco.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e){
            throw new DbException("Erro no Arquivo de Conexão com o Banco de Dados");
        }
    }

}