package pe.edu.upc.b2capp.model;

/**
 * Created by Andres on 24/06/2015.
 */
public class AddFavorito {
    int IdInmueble;
    int IdUsuario;

    public AddFavorito() {
    }

    public int getIdInmueble() {
        return IdInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        IdInmueble = idInmueble;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }
}
