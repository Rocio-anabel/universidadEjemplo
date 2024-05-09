
package universidadejemplo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




public class Main {

    
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidad","root","");
            String sql="INSERT INTO alumnos( dni, apellido, nombre, fecha_nacimiento, estado) VALUES('456456','gonzalez','juan','1998-05-09',true),('349839','gomez','gonzalo','2001-04-09',true),('231231','fernandez','rocio','2004-03-05' ,true)";
          // PreparedStatement ps=con.prepareStatement(sql);
           //ps.executeUpdate();
            String mat="INSERT INTO materia( nombre, año, estado) VALUES ('matematica','2024',true),('lengua','2023',true),('biologia','2024',true),('geografia','2023',true)";
            //PreparedStatement ps=con.prepareStatement(mat);
           //ps.executeUpdate();
           String ins="INSERT INTO inscripciones( nota, id_alumnos, id_materia) VALUES('7','4','1'),('8','4','2'),('9','5','1'),('7','5','3'),('6','6','3'),('9','6','4')";
           //PreparedStatement ps=con.prepareStatement(ins);
          // ps.executeUpdate();
           String sup="SELECT i.id_alumnos, a.nombre,a.apellido,a.fecha_nacimiento,a.dni, nota FROM inscripciones i, alumnos a WHERE i.id_alumnos=a.id_alumnos and nota>8";
           PreparedStatement ps=con.prepareStatement(sup);
          ResultSet datos=ps.executeQuery();
            while (datos.next()) {
              int id=datos.getInt("i.id_alumnos");
              String nombre=datos.getString("a.nombre");
              String apellido=datos.getString("a.apellido");
              Date fecha=datos.getDate("a.fecha_nacimiento");
              int dni=datos.getInt("a.dni");
              int nota=datos.getInt("nota");
                System.out.println(" id: "+id+"\n nombre: "+nombre+ "\n apellido: "+apellido+"\n fecha: "+fecha+"\n dni: "+dni+ "\n nota: "+nota);
                
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el Driver");
            
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error ");
              
        }
        
    }
    
}
