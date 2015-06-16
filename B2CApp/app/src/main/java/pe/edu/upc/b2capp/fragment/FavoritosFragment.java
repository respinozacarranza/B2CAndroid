package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.adapter.FavoritosAdapter;
import pe.edu.upc.b2capp.model.InmuebleSimple;

/**
 * Created by Renato on 6/8/2015.
 */
public class FavoritosFragment extends Fragment{

    ArrayList<InmuebleSimple> dataset;
    ListView listView;
    //FavoritosAdapter mFavoritosAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Un fragmento no tiene un contexto , como si lo tiene un Activity
        String URL = "http://172.20.10.4:8080/B2CWS/favoritos/1";
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        //Intefaz de la peticion, context+ getActivity() : todos los widget reciben un contexto
        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Espere ...", "Cargando datos...");

        JsonArrayRequest req = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.i("mirespuesta", response.toString());
                dataset = (ArrayList<InmuebleSimple>) parser(response);
                ListView listView = (ListView) getActivity().findViewById(R.id.listView_favoritos);
                listView.setAdapter(new FavoritosAdapter(dataset,getActivity()));
                progressDialog.cancel();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                Toast toast = Toast.makeText(getActivity(), "Error en la conexion", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        queue.add(req);

    }

    public List<InmuebleSimple> parser (JSONArray response){

        List<InmuebleSimple> inmueblesAux = new ArrayList<InmuebleSimple>();

        for(int i = 0; i<response.length(); i++){

            InmuebleSimple inms = new InmuebleSimple();

            try {

                JSONObject jsonObject = (JSONObject) response.get(i);
                inms.setId(jsonObject.getInt("id"));
                inms.setTitulo(jsonObject.getString("titulo"));
                inms.setDireccion(jsonObject.getString("direccion"));
                inms.setPrecio(BigDecimal.valueOf(jsonObject.getDouble("precio")));
                inms.setTipoTransaccion(jsonObject.getString("tipoTransaccion"));
                inmueblesAux.add(inms);
                Log.i("dato", inms.getTitulo());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return inmueblesAux;
    }

}
