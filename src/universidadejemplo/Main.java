
package universidadejemplo;

import java.sql.*;
import javax.swing.JOptionPane;




public class Main {

    
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el Driver");
        }
        
    }
    
}
