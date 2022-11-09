
package Models;

import java.io.Serializable;

public class Usuarios implements Serializable{
    
    private static final long serialVersionUID=1L;
    private int id;
    private String nome;
    private String email;
    private String senha;
    
    public Usuarios(){
    }
    public Usuarios(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Usuarios(int id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
            sb.append("ID: "+ id);
            sb.append("\nNome: "+nome);
            sb.append("\nEmail: "+ email);
            sb.append("\nSenha: "+ senha);
        return sb.toString();
    }
    
    
}
