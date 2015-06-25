package pe.edu.upc.b2capp.connection;

/**
 * Created by Jose on 16/06/2015.
 */
public class UriConstant {
    public static final String URL = "http://b2c-cloud.whelastic.net/B2CWS";

    // Favoritos
    public static final String GET_FAVORITOS = "/favoritos/";
    public static final String DELETE_FAVORITO = "/favoritos/delete";
    public static final String ADD_FAVORITO = "/favoritos/add";

    //Inmueble
    public static final String CREATE_INMUEBLE = "/inmueble/create";
    public static final String GET_INMUEBLE = "/inmueble/";
    // Usuario
    public static final String LOGIN = "/user/login";
    public static final String CREATE_USER = "/user/create";
    public static final String UPDATE_USER = "/user/update";
}
