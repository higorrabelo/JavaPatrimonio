package DB;

import javax.swing.JOptionPane;

public class DbException extends RuntimeException{

    public static final long serialVersionUID = 1L;
    
    public DbException(String msg){
        super(msg);
        JOptionPane.showMessageDialog(null,msg);
    }

}