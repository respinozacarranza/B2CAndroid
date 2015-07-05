package pe.edu.upc.b2capp.model;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class ImagenOut {

    private int idImagen;
    private String imgBlob;
    private int idInmueble;

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(String imgBlob) {
        this.imgBlob = imgBlob;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }
}
