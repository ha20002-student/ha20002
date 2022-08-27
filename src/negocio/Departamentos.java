package negocio;

import java.sql.ResultSet;

public class Departamentos {
    
    Conexion cn = new Conexion();
    
    public ResultSet llenarDepartamentos(){
        return cn.getValores("SELECT * from departamentos"); 
    } 
    
    
}
