package modelos;

public class Clientes {

    private int idClientes;
    private int idTiposDocumentos;
    private String nombre;
    private String noDocumento;

    public Clientes() {
    }

    public Clientes(String nombre, String noDocumento) {
        this.nombre = nombre;
        this.noDocumento = noDocumento;
    }
    
    
    public Clientes(int idTiposDocumentos, String nombre, String noDocumento) {
        this.idTiposDocumentos = idTiposDocumentos;
        this.nombre = nombre;
        this.noDocumento = noDocumento;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdTiposDocumentos() {
        return idTiposDocumentos;
    }

    public void setIdTiposDocumentos(int idTiposDocumentos) {
        this.idTiposDocumentos = idTiposDocumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    

}
