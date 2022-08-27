package negocio;

import java.sql.ResultSet;

public class Municipios {
    
    Conexion cn = new Conexion();
    
    public ResultSet llenarMunicipios(int departamento){
        return cn.getValores("SELECT * FROM municipios WHERE departamento='"+departamento+"'");
    }
    
}
