
package datos;

import static datos.Conexion.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelos.Recaudo;


public class RecaudoDAO {
    private static final String SQL_SELECT = "SELECT * FROM recaudo";
    private static final String SQL_INSERT = "INSERT INTO recaudo(idclientes, idproveedores, noreferencia, valor, fechavencimiento) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_ID = "SELECT idclientes, idproveedores, noreferencia, valor, fechavencimiento FROM recaudo WHERE idrecaudo=?";
    private static final String SQL_SELECT_REF = "SELECT idclientes, idproveedores, noreferencia, valor, fechavencimiento FROM recaudo WHERE noreferencia=?";
    private static final String SQL_DELETE = "DELETE FROM recaudo WHERE idrecaudo=?";
    private static final String SQL_UPDATE = "UPDATE recaudo SET idclientes=?, idproveedores=?, noreferencia=?, valor=?, fechavencimiento=?  WHERE idrecaudo=?";
    
    public Recaudo selectById(int idRecaudo){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Recaudo recaudo = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, idRecaudo);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                int idClientes = rs.getInt("idClientes");
                int idProveedores = rs.getInt("idProveedores");
                String noReferencia = rs.getString("noReferencia");
                float valor = rs.getFloat("valor");
                Date fechaVencimiento = rs.getDate("fechaVencimiento");
                
                recaudo = new Recaudo(idClientes, idProveedores, noReferencia, valor, fechaVencimiento);
                recaudo.setIdRecaudo(idRecaudo);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return recaudo;
    }
    
    public String selectByRef(String referencia){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String recaudo = "Referencia no encontrada";
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_REF);
            stmt.setString(1, referencia);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                int idClientes = rs.getInt("idClientes");
                int idProveedores = rs.getInt("idProveedores");
                String noReferencia = rs.getString("noReferencia");
                float valor = rs.getFloat("valor");
                Date fechaVencimiento = rs.getDate("fechaVencimiento");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                recaudo =idClientes + "," + noReferencia + "," + valor + "," + sdf.format(fechaVencimiento);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return recaudo;
    }
    
    public List<Recaudo> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Recaudo recaudo = null;
        List<Recaudo> recaudos = new ArrayList<Recaudo>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idRecaudo = rs.getInt("idRecaudo");
                int idClientes = rs.getInt("idClientes");
                int idProveedores = rs.getInt("idProveedores");
                String noReferencia = rs.getString("noReferencia");
                float valor = rs.getFloat("valor");
                Date fechaVencimiento = rs.getDate("fechaVencimiento");

                recaudo = new Recaudo(idClientes, idProveedores, noReferencia, valor, fechaVencimiento);
                recaudo.setIdRecaudo(idRecaudo);
                recaudos.add(recaudo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return recaudos;
    }
    
    public int insertar(Recaudo recaudo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, recaudo.getIdClientes());
            stmt.setInt(2, recaudo.getIdProveedores());
            stmt.setString(3, recaudo.getNoReferencia());
            stmt.setFloat(4, recaudo.getValor());
            stmt.setDate(5, (Date) recaudo.getFechaVencimiento());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public int actualizar(Recaudo recaudo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, recaudo.getIdClientes());
            stmt.setInt(2, recaudo.getIdProveedores());
            stmt.setString(3, recaudo.getNoReferencia());
            stmt.setFloat(4, recaudo.getValor());
            stmt.setDate(5, (Date) recaudo.getFechaVencimiento());
            stmt.setInt(6, recaudo.getIdRecaudo());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public int eliminar(Recaudo recaudo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, recaudo.getIdRecaudo());
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
