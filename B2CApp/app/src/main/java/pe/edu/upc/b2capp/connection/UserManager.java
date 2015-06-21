package pe.edu.upc.b2capp.connection;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import pe.edu.upc.b2capp.activity.MainActivity;
import pe.edu.upc.b2capp.model.Usuario;

/**
 * Created by Andres on 19/06/2015.
 */
public class UserManager {

    private Usuario usuario_registrado;
    private Usuario usuario_modificado;
    private static UserManager instance = null;

    public Usuario getUsuario_registrado() {
        return usuario_registrado;
    }

    public void setUsuario_registrado(Usuario usuario_registrado) {
        this.usuario_registrado = usuario_registrado;
    }

    protected UserManager(Context context){}

    public void RegistrarUsuario(Usuario usuario, final Context context){
        final ProgressDialog progressDialog = ProgressDialog.show(context, "Espere...", "Registrando Usuario...");

        final Gson gson = new Gson();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, UriConstant.URL + UriConstant.CREATE_USER, gson.toJson(usuario),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        usuario_registrado = new Usuario();
                        try {
                            usuario_registrado = gson.fromJson(response.toString(), Usuario.class);
                            progressDialog.cancel();

                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                            Toast.makeText(context, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                        } catch (Exception ex) {
                            progressDialog.cancel();
                            Toast.makeText(context, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.cancel();
                        Toast.makeText(context,"Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueueManager
                .getInstance(context)
                .addToRequestQueue(jsonObjectRequest);
    }

    public void ModificarUsuario(Usuario usuario, final Context context){
        final ProgressDialog progressDialog = ProgressDialog.show(context, "Espere...", "Modificando Usuario...");

        final Gson gson = new Gson();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, UriConstant.URL + UriConstant.UPDATE_USER, gson.toJson(usuario),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        usuario_modificado = new Usuario();
                        try {
                            usuario_modificado = gson.fromJson(response.toString(), Usuario.class);
                            progressDialog.cancel();
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                            Toast.makeText(context, "Usuario Modificado", Toast.LENGTH_SHORT).show();
                        } catch (Exception ex) {
                            progressDialog.cancel();
                            Toast.makeText(context, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                Toast.makeText(context,"Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        RequestQueueManager
                .getInstance(context)
                .addToRequestQueue(jsonObjectRequest);

    }

    public static UserManager getInstance(Context context){
        if(instance == null){
            instance = new UserManager(context);
        }
        return instance;
    }

}
