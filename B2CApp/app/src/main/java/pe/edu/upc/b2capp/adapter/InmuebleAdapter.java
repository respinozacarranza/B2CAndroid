package pe.edu.upc.b2capp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.connection.RequestQueueManager;
import pe.edu.upc.b2capp.model.InmuebleSimple;

/**
 * Created by Renato on 6/8/2015.
 */
public class InmuebleAdapter extends BaseAdapter{

    private List<InmuebleSimple> inmuebles;
    private String TAG = getClass().getSimpleName();
    private Context context;

    public InmuebleAdapter(final Context context, String Uri){

        this.context = context;
        // Nueva petición JSONArray
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(Uri, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.i("mirespuesta", response.toString());
                setInmuebles(parseJson(response));
                notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast toast = Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        // Añadir petición a la cola
        RequestQueueManager
                .getInstance(context)
                .addToRequestQueue(jsArrayRequest);
    }

    @Override
    public int getCount() {
        if (getInmuebles() != null)
            return getInmuebles().size();
        else return 0;
    }

    @Override
    public Object getItem(int position) {
        return getInmuebles().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View listItemView = convertView;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_inmueble,parent , false);
        }

        final ImageView img = (ImageView) convertView.findViewById(R.id.avatar_inmueble);
        TextView t1 = (TextView)convertView.findViewById(R.id.textViewL);
        TextView t2 = (TextView)convertView.findViewById(R.id.textViewS);
        TextView t3 = (TextView)convertView.findViewById(R.id.textViewM);

        TextView t4 = (TextView)convertView.findViewById(R.id.textViewPrecio);

        InmuebleSimple inmuebleSimple = getInmuebles().get(position);

        t1.setText(inmuebleSimple.getTitulo());
        t2.setText(inmuebleSimple.getDireccion());
        t3.setText(inmuebleSimple.getTipoTransaccion());
        t4.setText(inmuebleSimple.getPrecio().toString());

        //Decodificar imagen
        byte[] imageByteArray =  inmuebleSimple.getImagen();
        byte[] decodedString = Base64.decode(imageByteArray, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        //Asignar imagen a ImageView
        img.setImageBitmap(decodedByte);
        return convertView;
    }

    public List<InmuebleSimple> parseJson (JSONArray response) {

        List<InmuebleSimple> inmueblesAux = new ArrayList<>();

        for(int i = 0; i<response.length(); i++){

            InmuebleSimple inms = new InmuebleSimple();

            try {

                JSONObject jsonObject = (JSONObject) response.get(i);
                inms.setId(jsonObject.getInt("id"));
                inms.setTitulo(jsonObject.getString("titulo"));
                inms.setDireccion(jsonObject.getString("direccion"));
                inms.setPrecio(BigDecimal.valueOf(jsonObject.getDouble("precio")));
                inms.setTipoTransaccion(jsonObject.getString("tipoTransaccion"));
                inms.setImagen(jsonObject.getString("imagen").getBytes(Charset.forName("UTF-8")));
                inmueblesAux.add(inms);
                Log.i("dato", inms.getTitulo());

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }
        return inmueblesAux;
    }

    public List<InmuebleSimple> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<InmuebleSimple> inmuebles) {
        this.inmuebles = inmuebles;
    }
}
