
package datos;

import static datos.Conexion.*;
import java.sql.*;
import java.util.*;
import modelos.Clientes;


public class ClientesDAO {
    private static final String SQL_SELECT = "SELECT * FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(idtiposdocumentos, nombre, nodocumento) VALUES (?,?,?)";
    private static final String SQL_SELECT_ID = "SELECT idtiposdocumentos, nombre, nodocumento FROM clientes WHERE idclientes=?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE idclientes=?";
    private static final String SQL_UPDATE = "UPDATE clientes SET idtiposdocumentos=?, nombre=?, nodocumento=?  WHERE idclientes=?";
    
    public Clientes selectById(int idClientes){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, idClientes);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                int idTiposDocumentos = rs.getInt("idTiposDocumentos");
                String nombre = rs.getString("nombre");
                String noDocumento = rs.getString("noDocumento");
                cliente = new Clientes(idTiposDocumentos, nombre, noDocumento);
                cliente.setIdClientes(idClientes);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return cliente;
    }
    
    public String devolverString(int idClientes){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String cliente = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, idClientes);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                int idTiposDocumentos = rs.getInt("idTiposDocumentos");
                String nombre = rs.getString("nombre");
                String noDocumento = rs.getString("noDocumento");
                cliente = nombre + "," + noDocumento ;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return cliente;
    }
    
    public List<Clientes> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;
        List<Clientes> clientes = new ArrayList<Clientes>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idClientes = rs.getInt("idClientes");
                int idTiposDocumentos = rs.getInt("idTiposDocumentos");
                String noDocumento = rs.getString("noDocumento");
                String nombre = rs.getString("nombre");

                cliente = new Clientes(idTiposDocumentos, nombre, noDocumento);
                cliente.setIdClientes(idClientes);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return clientes;
    }
    
    public int insertar(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, clientes.getIdTiposDocumentos());
            stmt.setString(2, clientes.getNombre());
            stmt.setString(3, clientes.getNoDocumento());
            
            registros = stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            
            if (rs.next()){
                registros = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public int actualizar(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, clientes.getIdTiposDocumentos());
            stmt.setString(2, clientes.getNombre());
            stmt.setString(3, clientes.getNoDocumento());
            stmt.setInt(4, clientes.getIdClientes());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public int eliminar(Clientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, clientes.getIdClientes());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
}
