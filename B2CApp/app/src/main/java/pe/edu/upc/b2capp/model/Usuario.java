package pe.edu.upc.b2capp.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class Usuario {

    private Integer idUsuario;
    private String usuario;
    private String password;
    private String nombre;
    private String email;
    private String ruc;
    private String direccion;
    private String web;
    private String telefono;
    private Integer idTipoUsuario;

    public void setAttributesFromJson(JSONObject response) throws JSONException{
        this.setIdUsuario(response.getInt("idUsuario"));
        this.setNombre(response.getString("nombre"));
        this.setEmail(response.getString("email"));
        this.setRuc(response.getString("ruc"));
        this.setDireccion(response.getString("web"));
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}
