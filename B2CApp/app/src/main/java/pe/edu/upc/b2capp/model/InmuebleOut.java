package pe.edu.upc.b2capp.model;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class InmuebleOut {

    private Integer idInmueble;
    private String titulo;
    private String direccion;
    private String distrito;
    private Integer area;
    private Integer dormitorios;
    private Integer banos;
    private Integer estacionamientos;
    private Integer antiguedad;
    private Double latitud;
    private Integer longitud;
    private String descripcion;
    private Double precio;
    private Integer cantFavoritos;
    private Integer idUsuario;
    private Integer idtTipoTransaccion;
    private Integer idTipoInmueble;

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(Integer dormitorios) {
        this.dormitorios = dormitorios;
    }

    public Integer getBanos() {
        return banos;
    }

    public void setBanos(Integer banos) {
        this.banos = banos;
    }

    public Integer getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(Integer estacionamientos) {
        this.estacionamientos = estacionamientos;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantFavoritos() {
        return cantFavoritos;
    }

    public void setCantFavoritos(Integer cantFavoritos) {
        this.cantFavoritos = cantFavoritos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdtTipoTransaccion() {
        return idtTipoTransaccion;
    }

    public void setIdtTipoTransaccion(Integer idtTipoTransaccion) {
        this.idtTipoTransaccion = idtTipoTransaccion;
    }

    public Integer getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }
}
