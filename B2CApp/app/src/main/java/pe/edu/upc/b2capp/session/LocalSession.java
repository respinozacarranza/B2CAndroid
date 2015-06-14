package pe.edu.upc.b2capp.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import pe.edu.upc.b2capp.models.Usuario;

/**
 * Created by Jose on 14/06/2015.
 */
public class LocalSession {

    private final String USER_PREFS = "user_prefs";
    private Usuario loggedUser;

    private static LocalSession instance = null;

    protected LocalSession() {

    }
    public static LocalSession getInstance(Context context) {
        if(instance == null) {
            instance = new LocalSession();
        }
        return instance;
    }


    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Usuario loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean startSession(String user, String password, Context context) {
        //llamar al metodo de victor para validar usuario
        //hardcodeado por mientras
        Usuario u = new Usuario();
        u.setUsuario("gesek");
        u.setNombre("Andres");
        saveUser(u, context);
        this.loggedUser = u;
        return true;
    }

    public void closeSession() {

    }

    public void saveUser(Usuario u, Context context) {

        SharedPreferences settings = context.getSharedPreferences(USER_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(u);
        editor.putString("loggedUser", json);
        editor.commit();
    }

}
