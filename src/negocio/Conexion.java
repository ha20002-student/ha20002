package negocio;

import java.sql.Connection; //Puntero a la base de datos, proporciona el contexto para ResultSet y Statement
import java.sql.DriverManager; //Lleva el control de los gestores JDBC disponibles
import java.sql.ResultSet; //Contiene los datos resultado de una sentencia SQL
import java.sql.SQLException;
import java.sql.Statement; //Ejecución de una sentencia SQL, devuelve un ResultSet
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private final String url = "jdbc:mysql://localhost:3306/negocio?characterEncoding=utf8";
    private final String login = "root"; //Administrador de MySQL
    private final String password = "12345678";
    private Connection cnx = null;
    private Statement sttm = null;
    private ResultSet rst = null;

    //Método para update, insert and delete
    public void UID(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //instanciar la clase
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement(); //Crea un objeto SQLServerStatement para enviar instrucciones SQL a la base de datos.
            sttm.executeUpdate(sql);//Ejecuta la instrucción SQL determinada, que puede ser una instrucción INSERT, UPDATE, DELETE o una instrucción SQL que no devuelve nada
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(1); //salir de aplicación
        }
    }

    //Método para Consultar
    public ResultSet getValores(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            rst = sttm.executeQuery(sql);  //resultset
        } catch (ClassNotFoundException | SQLException c) {
            JOptionPane.showMessageDialog(null, "Error: " + c.getMessage());
            System.exit(1);
        } finally { //actividad que siempre ocurre
            return rst;
        }
    }
    
    public void desconectar() {
        try {
            cnx.close();
            System.out.println("Se cerró la conexión");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }
    
        public void cerrar() {
        try {
            this.cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public Connection getConexion() {
        return this.cnx;
    }
        
}
