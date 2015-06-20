package pe.edu.upc.b2capp.session;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import pe.edu.upc.b2capp.activity.MainActivity;
import pe.edu.upc.b2capp.connection.RequestQueueManager;
import pe.edu.upc.b2capp.connection.UriConstant;
import pe.edu.upc.b2capp.model.Login;
import pe.edu.upc.b2capp.model.Usuario;

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

    public void startSession(String user, String password, final Context context) {
        final ProgressDialog progressDialog = ProgressDialog
                .show(context, "Espere ...", "Iniciando sesión...");
        Login login = new Login();
        login.setUsuario(user);
        login.setPassword(password);

        final Gson gson = new Gson();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                UriConstant.URL + UriConstant.LOGIN,
                gson.toJson(login),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        loggedUser = new Usuario();
                        try {
                            //Obtengo el usuario del response
                            //Uso Gson para castear el json response
                            loggedUser = gson.fromJson(response.toString(), Usuario.class);
                            //Guardo el usuario mediante sharedPreferences
                            saveUser(loggedUser, context);
                            //Cierro el progressDialog
                            progressDialog.cancel();
                            //Regreso a la pantalla principal
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                            //Toast informativo
                            Toast.makeText(context, "Sesion iniciada", Toast.LENGTH_SHORT)
                                    .show();
                        } catch (Exception ex) {
                            loggedUser = null;
                            progressDialog.cancel();
                            Toast.makeText(context,"Error: " + ex.getMessage(), Toast.LENGTH_LONG)
                                    .show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.cancel();
                        Toast.makeText(context,"Error: " + error.getMessage(), Toast.LENGTH_LONG)
                                .show();
                    }
                });

        RequestQueueManager
                .getInstance(context)
                .addToRequestQueue(jsonObjectRequest);
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

    public Boolean sessionStarted() {
        return loggedUser != null;
    }

}
