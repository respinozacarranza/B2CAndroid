package pe.edu.upc.b2capp.connection;

/**
 * Created by Jose on 16/06/2015.
 */
public class UriConstant {
    public static final String URL_BASE = "http://b2c-cloud.whelastic.net/B2CWS";
    //public static final String URL_BASE = "http://192.168.1.41:8080/B2CWS";

    // Favoritos
    public static final String GET_FAVORITOS = "/favoritos/";
    public static final String DELETE_FAVORITO = "/favoritos/delete";
    public static final String ADD_FAVORITO = "/favoritos/add";
    public static final String ES_FAVORITO = "/favoritos/esfavorito";

    //Inmueble
    public static final String CREATE_INMUEBLE = "/inmueble/create";
    public static final String GET_INMUEBLE = "/inmueble/";
    public static final String GET_ALL_INMUEBLE = "/inmuebles";
    public static final String BUSCAR_INMUEBLES = "/inmuebles/buscar?";
    public static final String INMUEBLES_PROPIOS = "/inmuebles/propios/";
    public static final String INMUEBLE_RADIO = "/inmueble/radio";

    // Usuario
    public static final String LOGIN = "/user/login";
    public static final String CREATE_USER = "/user/create";
    public static final String UPDATE_USER = "/user/update";

}
