package pe.edu.upc.b2capp.model;

import java.util.Date;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class Favorito {

    private Integer idInmueble;
    private Integer idUsuario;

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
