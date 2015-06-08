package pe.edu.upc.b2capp.models;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class TipoUsuario {

    private int idTipoUsuario;
    private String descripcion;

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
