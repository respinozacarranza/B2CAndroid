package pe.edu.upc.b2capp.connection;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import pe.edu.upc.b2capp.model.AddFavorito;

/**
 * Created by Andres on 24/06/2015.
 */

public class FavoritosManager {

    private AddFavorito addFavorito_registrado;
    private AddFavorito addFavorito_eliminado;
    private static FavoritosManager instance = null;

    protected FavoritosManager(Context context){}

    public void RegistrarFavorito(AddFavorito addFavorito, final Context context){
        final ProgressDialog progressDialog = ProgressDialog.show(context, "Espere...", "Registrando Favorito...");

        final Gson gson = new Gson();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, UriConstant.URL_BASE + UriConstant.ADD_FAVORITO, gson.toJson(addFavorito),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        addFavorito_registrado = new AddFavorito();
                        try {
                            addFavorito_registrado = gson.fromJson(response.toString(), AddFavorito.class);
                            progressDialog.cancel();
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

    public void EliminarFavorito(AddFavorito addFavorito, final Context context){

        final ProgressDialog progressDialog = ProgressDialog.show(context, "Espere...", "Eliminando Favorito...");

        final Gson gson = new Gson();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, UriConstant.URL_BASE + UriConstant.DELETE_FAVORITO, gson.toJson(addFavorito),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        addFavorito_registrado = new AddFavorito();
                        try {
                            addFavorito_eliminado = gson.fromJson(response.toString(), AddFavorito.class);
                            progressDialog.cancel();
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
}
