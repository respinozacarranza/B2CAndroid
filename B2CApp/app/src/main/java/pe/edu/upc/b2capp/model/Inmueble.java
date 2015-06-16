package pe.edu.upc.b2capp.model;

import java.util.Date;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class Inmueble {

    private  int idInmueble;
    private  String titulo;
    private String direccion;
    private  String distrito;
    private int area;
    private int dormitorios;
    private int banos;
    private int estacionamientos;
    private int antiguedad;
    private int latitud;
    private int longitud;
    private String descripcion;
    private double precio;
    private int cantFavoritos;
    private Date fechaCreacion;
    private boolean eliminado;
    private Usuario idUsuario;
    private TipoTransaccion idtTipoTransaccion;
    private TipoInmueble idTipoInmueble;



    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
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

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantFavoritos() {
        return cantFavoritos;
    }

    public void setCantFavoritos(int cantFavoritos) {
        this.cantFavoritos = cantFavoritos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoTransaccion getIdtTipoTransaccion() {
        return idtTipoTransaccion;
    }

    public void setIdtTipoTransaccion(TipoTransaccion idtTipoTransaccion) {
        this.idtTipoTransaccion = idtTipoTransaccion;
    }

    public TipoInmueble getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(TipoInmueble idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        this.dormitorios = dormitorios;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public int getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(int estacionamientos) {
        this.estacionamientos = estacionamientos;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
