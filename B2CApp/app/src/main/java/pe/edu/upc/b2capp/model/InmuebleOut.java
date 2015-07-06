package pe.edu.upc.b2capp.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class InmuebleOut {

    private Integer idInmueble;

    private String titulo;

    private String direccion;

    private String distrito;

    private BigDecimal latitud;

    private BigDecimal longitud;

    private String descripcion;

    private BigDecimal precio;

    private Integer idUsuario;

    private Integer idTipoTransaccion;

    private Integer idTipoInmueble;

    private BigDecimal areaTotal;

    private BigDecimal areaConstruida;

    private BigDecimal precioDolares;

    private BigDecimal precioSoles;

    private Integer dormitorios;

    private Integer banos;

    private Integer antiguedad;

    private List<ImagenOut> imagenList;



    public List<ImagenOut> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<ImagenOut> imagenList) {
        this.imagenList = imagenList;
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Integer getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
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
}
