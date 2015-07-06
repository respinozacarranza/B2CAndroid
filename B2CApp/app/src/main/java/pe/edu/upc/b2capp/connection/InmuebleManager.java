package pe.edu.upc.b2capp.connection;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import pe.edu.upc.b2capp.activity.MainActivity;
import pe.edu.upc.b2capp.model.InmuebleOut;
import pe.edu.upc.b2capp.model.Respuesta;

/**
 * Created by Jose on 22/06/2015.
 */
public class InmuebleManager {

    //Inicio singleton
    private static InmuebleManager singleton;
    private static Context context;
    private final String TAG = this.getClass().getSimpleName();

    private InmuebleManager(Context context) {
        InmuebleManager.context = context;
    }

    public static synchronized InmuebleManager getInstance(Context context) {
        if (singleton == null) {
            singleton = new InmuebleManager(context);
        }
        return singleton;
    }
    //Fin singleton

    public void insertarInmueble(final InmuebleOut inmueble) {
        final ProgressDialog progressDialog =
                ProgressDialog.show(context, "Espere...", "Registrando Inmueble...");
        final Gson gson = new Gson();
        String json = gson.toJson(inmueble);
        Log.i(TAG, json);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, UriConstant.URL_BASE + UriConstant.CREATE_INMUEBLE, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Respuesta respuesta = new Respuesta();
                        try {
                            respuesta = gson.fromJson(response.toString(), Respuesta.class);
                            progressDialog.cancel();
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                            Toast.makeText(context, "Inmueble Registrado", Toast.LENGTH_SHORT).show();
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
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy( 1000000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueueManager
                .getInstance(context)
                .addToRequestQueue(jsonObjectRequest);
    }

}
