package pe.edu.upc.b2capp.model;

/**
 * Created by Jose on 23/06/2015.
 */
public class ImagenSimple {
    private byte[] imagenBlob;
    public ImagenSimple() {
    }

    public byte[] getImagenBlob() {
        return imagenBlob;
    }

    public void setImagenBlob(byte[] imagenBlob) {
        this.imagenBlob = imagenBlob;
    }
}
