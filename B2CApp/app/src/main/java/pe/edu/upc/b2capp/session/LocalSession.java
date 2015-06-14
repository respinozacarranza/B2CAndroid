package pe.edu.upc.b2capp.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

import pe.edu.upc.b2capp.models.Usuario;

/**
 * Created by Jose on 14/06/2015.
 */
public class LocalSession {

    private final String USER_PREFS = "user_file";
    private final String LOGGED_USER_KEY = "loggedUser";
    private Usuario loggedUser;

    private static LocalSession instance = null;

    protected LocalSession() {

    }

    protected LocalSession(Context context) {
        restoreUser(context);
    }

    public static LocalSession getInstance(Context context) {
        if(instance == null) {
            instance = new LocalSession(context);
        }
        return instance;
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Usuario loggedUser) {
        this.loggedUser = loggedUser;
    }

    public void restoreUser(Context context) {
        SharedPreferences settings = context.getSharedPreferences(USER_PREFS, 0);
        String json = settings.getString(LOGGED_USER_KEY, null);
        Gson gson = new Gson();
        Usuario u = gson.fromJson(json, Usuario.class);
        this.loggedUser = u;
    }

    public boolean startSession(String user, String password, Context context) {
        //llamar al metodo de victor para validar usuario
        //hardcodeado por mientras
        Usuario u = new Usuario();
        u.setUsuario("gesek");
        u.setNombre("Andres");
        saveUser(u, context);
        this.loggedUser = u;
        Toast toast = Toast.makeText(context, "Sesion iniciada", Toast.LENGTH_SHORT);
        toast.show();
        return true;
    }

    public void closeSession(Context context) {

        SharedPreferences settings = context.getSharedPreferences(USER_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(LOGGED_USER_KEY, null);
        editor.commit();
        this.loggedUser = null;
        Toast toast = Toast.makeText(context, "Sesion cerrada", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void saveUser(Usuario u, Context context) {

        SharedPreferences settings = context.getSharedPreferences(USER_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(u);
        editor.putString(LOGGED_USER_KEY, json);
        editor.commit();
    }

}
