package pe.edu.upc.b2capp.model;

import java.util.Date;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class Favorito {

    private  int idfavorito;
    private Date fechaCreacion;
    private InmuebleOut idInmueble;
    private Usuario idUsuario;


    public int getIdfavoritos() {
        return idfavorito;
    }

    public void setIdfavoritos(int idfavoritos) {
        this.idfavorito = idfavoritos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public InmuebleOut getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(InmuebleOut idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
