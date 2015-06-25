package pe.edu.upc.b2capp.model;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class InmuebleIn {

    private Integer idInmueble;

    private String titulo;

    private String direccion;

    private String distrito;

    private BigDecimal latitud;

    private BigDecimal longitud;

    private String descripcion;

    private BigDecimal precio;

    private BigInteger cantidadFavoritos;

    private Date fechaCreacion;

    private Integer idUsuario;

    private String usuario;

    private TipoTransaccion tipoTransaccion;

    private TipoInmueble tipoInmueble;

    private BigDecimal areaTotal;

    private BigDecimal areaConstruida;

    private BigDecimal precioDolares;

    private BigDecimal precioSoles;

    private Integer dormitorios;

    private Integer banos;

    private Integer antiguedad;

    private List<ImagenSimple> imagenList;

    public InmuebleIn() {
    }


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

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigInteger getCantidadFavoritos() {
        return cantidadFavoritos;
    }

    public void setCantidadFavoritos(BigInteger cantidadFavoritos) {
        this.cantidadFavoritos = cantidadFavoritos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public BigDecimal getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(BigDecimal areaTotal) {
        this.areaTotal = areaTotal;
    }

    public BigDecimal getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(BigDecimal areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public BigDecimal getPrecioDolares() {
        return precioDolares;
    }

    public void setPrecioDolares(BigDecimal precioDolares) {
        this.precioDolares = precioDolares;
    }

    public BigDecimal getPrecioSoles() {
        return precioSoles;
    }

    public void setPrecioSoles(BigDecimal precioSoles) {
        this.precioSoles = precioSoles;
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

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public List<ImagenSimple> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<ImagenSimple> imagenList) {
        this.imagenList = imagenList;
    }

}
