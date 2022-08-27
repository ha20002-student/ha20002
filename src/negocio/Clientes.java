package negocio;

import java.sql.ResultSet;


public class Clientes {
    
    Conexion cn = new Conexion();
    
    public void insertar(String id, String nombre, String apellido, int departamento, int municipio){
        cn.UID("INSERT INTO clientes(id,nombre,apellido,departamento,municipio) VALUES ('"+id+"','"+nombre+"','"+apellido+"','"+departamento+"','"+municipio+"')");
    }
    
    public ResultSet llenarTabla(){
        return cn.getValores("SELECT clientes.id, clientes.nombre, clientes.apellido, clientes.departamento, clientes.municipio, departamentos.nombreDepartamento, municipios.nombreMunicipio FROM (departamentos INNER JOIN clientes ON departamentos.departamento = clientes.departamento) INNER JOIN municipios ON (municipios.municipio = clientes.municipio) AND (departamentos.departamento = municipios.departamento)");
    }
    
}
