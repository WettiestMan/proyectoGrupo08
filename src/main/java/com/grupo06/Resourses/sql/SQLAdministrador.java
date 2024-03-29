
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.usuario.Administrador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristopher
 */
public class SQLAdministrador {
    private static final String SELECT = "SELECT * FROM Administradores";
    private static final String INSERT = "INSERT INTO Administradores(fechaNac,DNI,nombre,apellidos,usuario,contrasena) VALUES(?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Administradores SET fechaNac=?,DNI=?,nombre=?,apellidos=?,usuario=?,contrasena=? WHERE id_Administrador=?";
    private static final String DELETE = "DELETE FROM Administradores WHERE id_Administrador=?";

    public List<Administrador> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Administrador> administradores = new ArrayList<>();
        Administrador administrador = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Administrador");
                Date fechaNacimiento = rs.getDate("fechaNac");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("DNI");
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");

                administrador = new Administrador(id,fechaNacimiento.toLocalDate(),dni, nombre, apellidos, usuario,contrasena);
                administradores.add(administrador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(rs);
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return administradores;
    }
    
    public int SQL_INSERT(Administrador administrador){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setDate(1, (Date) Date.from(administrador.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, administrador.getDNI());
            pstmt.setString(3, administrador.getNombre());
            pstmt.setString(4, administrador.getApellidos());
            pstmt.setString(5, administrador.getUsuario());
            pstmt.setString(6, administrador.getContrasena());
         
            registros = pstmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int SQL_UPDATE(Administrador administrador){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setDate(1, (Date) Date.from(administrador.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, administrador.getDNI());
            pstmt.setString(3, administrador.getNombre());
            pstmt.setString(4, administrador.getApellidos());
            pstmt.setString(5, administrador.getUsuario());
            pstmt.setString(6, administrador.getContrasena());
            pstmt.setInt(7, administrador.getId());
            
            registros = pstmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int SQL_DELETE(Administrador administrador){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, administrador.getId());
            
            registros = pstmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
