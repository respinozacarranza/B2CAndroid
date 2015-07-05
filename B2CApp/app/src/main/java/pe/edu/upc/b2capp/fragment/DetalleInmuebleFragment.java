package pe.edu.upc.b2capp.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.connection.RequestQueueManager;
import pe.edu.upc.b2capp.connection.UriConstant;
import pe.edu.upc.b2capp.model.ImagenSimple;
import pe.edu.upc.b2capp.model.InmuebleIn;

/**
 * Created by Renato on 6/12/2015.
 */
public class DetalleInmuebleFragment extends Fragment{

    private Integer idInmueble;
    private InmuebleIn inmueble;

    private Button btnMensaje;
    private Button btnLlamada;
    private Button pruebaMandaCoord;


    public DetalleInmuebleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Activity activity = getActivity();
        Intent intent = activity.getIntent();

        View rootView = inflater.inflate(R.layout.fragment_detalle_inmueble, container, false);
        if (intent != null && intent.hasExtra("idInmueble")) {
            idInmueble = intent.getIntExtra("idInmueble", 0);
            final ProgressDialog progressDialog =
                    ProgressDialog.show(activity, "Espere...", "Obteniendo Inmueble...");
            String uri =
                    UriConstant.URL_BASE + UriConstant.GET_INMUEBLE + idInmueble.toString();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET, uri,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                inmueble = parseJson(response);
                                cargarInmueble(inmueble);
                                progressDialog.cancel();
                                Toast.makeText(activity, "Exito", Toast.LENGTH_LONG).show();

                            } catch (Exception ex) {
                                progressDialog.cancel();
                                Toast.makeText(activity, "Error en el parseo", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.cancel();
                    Toast.makeText(activity,"Error en la conexion. Vuelva a intentarlo", Toast.LENGTH_SHORT).show();
                }
            });

            RequestQueueManager
                    .getInstance(activity)
                    .addToRequestQueue(jsonObjectRequest);
        }
        return rootView;
    }

    public void cargarInmueble(InmuebleIn inmueblein) {

        //sliderShow = (SliderLayout) getView().findViewById(R.id.slider);
        //sliderShow.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        //sliderShow.setDuration(6000);
        for(ImagenSimple img: inmueblein.getImagenList()) {
            byte[] imageByteArray = img.getImagenBlob();
            byte[] decodedString = Base64.decode(imageByteArray, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            LinearLayout view = (LinearLayout) getActivity().findViewById(R.id.imagenesTelas);
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageBitmap(decodedByte);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(400);
            view.addView(imageView);
            //DefaultSliderView sliderView = new DefaultSliderView(getActivity());
            //sliderView.image("");
            //sliderShow.addSlider(sliderView);
            //ImageView img = (View)
        }
        TextView textView = (TextView)getActivity().findViewById(R.id.textViewTitulo);
        TextView textView2 = (TextView)getActivity().findViewById(R.id.textViewPrecio);
        TextView textView3 = (TextView)getActivity().findViewById(R.id.textViewArea);
        TextView textView4 = (TextView)getActivity().findViewById(R.id.textViewAntiguedad);
        TextView textView5 = (TextView)getActivity().findViewById(R.id.textViewDormitorios);
        TextView textView6 = (TextView)getActivity().findViewById(R.id.textViewBanos);
        TextView textView7 = (TextView)getActivity().findViewById(R.id.textViewEstacionamientos);
        TextView textView8 = (TextView)getActivity().findViewById(R.id.textViewDescripcion);

        textView.setText(inmueblein.getTitulo());
        textView2.setText("Precio: " + String.valueOf(inmueblein.getPrecio()));
        textView3.setText("Area: " + String.valueOf(inmueblein.getAreaTotal()));
        textView4.setText("Antiguedad: " + String.valueOf(inmueblein.getAntiguedad()));
        textView5.setText("Direccion: " + String.valueOf(inmueblein.getDireccion()));
        textView6.setText("Baños: " + String.valueOf(inmueblein.getBanos()));
        textView7.setText("Distrito: " + String.valueOf(inmueblein.getDistrito()));
        textView8.setText("Descripcion: " + inmueblein.getDescripcion());

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        final String para = "respinozacarranza@gmail.com";
        final String subject = "Deseo comunicarme";
        final String message = "B2C - MESSAGE";
        final String llamada = "948314023";

        btnMensaje = (Button)view.findViewById(R.id.btnEmail);
        btnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] { para });
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");

                startActivity(email);

            }
        });

        btnLlamada = (Button)view.findViewById(R.id.btnLlamar);
        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "tel: " + llamada;
                Intent llamada = new Intent(Intent.ACTION_CALL);
                llamada.setData(Uri.parse(uri));
                startActivity(llamada);
            }
        });

        pruebaMandaCoord = (Button)view.findViewById(R.id.btnPrueba);
        pruebaMandaCoord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng coordenadas = new LatLng(inmueble.getLatitud().doubleValue(),inmueble.getLongitud().doubleValue());
                Bundle args = new Bundle();
                args.putParcelable("coords",coordenadas);
                Intent i = new Intent();
                i.putExtra("bundle",args);
                startActivity(i);

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public InmuebleIn parseJson(JSONObject jsonObject) {
        InmuebleIn inmueble;
        try {
            inmueble = new InmuebleIn();
            inmueble.setIdInmueble(jsonObject.getInt("idInmueble"));
            inmueble.setAntiguedad(jsonObject.getInt("antiguedad"));
            inmueble.setAreaConstruida(BigDecimal.valueOf(jsonObject.getDouble("areaConstruida")));
            inmueble.setAreaTotal(BigDecimal.valueOf(jsonObject.getDouble("areaTotal")));
            inmueble.setBanos(jsonObject.getInt("banos"));
            inmueble.setCantidadFavoritos(BigInteger.valueOf(jsonObject.getLong("cantidadFavoritos")));
            inmueble.setDescripcion(jsonObject.getString("descripcion"));
            inmueble.setDireccion(jsonObject.getString("direccion"));
            inmueble.setDistrito(jsonObject.getString("distrito"));
            inmueble.setLatitud(BigDecimal.valueOf(jsonObject.getDouble("latitud")));
            inmueble.setLongitud(BigDecimal.valueOf(jsonObject.getDouble("longitud")));
            inmueble.setPrecio(BigDecimal.valueOf(jsonObject.getDouble("precio")));
            inmueble.setPrecioDolares(BigDecimal.valueOf(jsonObject.getDouble("precioDolares")));
            inmueble.setPrecioSoles(BigDecimal.valueOf(jsonObject.getDouble("precioSoles")));
            inmueble.setTitulo(jsonObject.getString("titulo"));
            inmueble.setDireccion(jsonObject.getString("direccion"));
            //Inicio obtener imagenes
            JSONArray imgArray = jsonObject.getJSONArray("imagenList");
            List<ImagenSimple> lstImagen = new ArrayList<>();
            for(int i=0; i < imgArray.length(); i++) {
                ImagenSimple imgSimple = new ImagenSimple();
                imgSimple.setImagenBlob(imgArray
                        .getJSONObject(i)
                        .getString("imagenBlob")
                        .getBytes(Charset.forName("UTF-8")));
                lstImagen.add(imgSimple);
            }
            inmueble.setImagenList(lstImagen);
            return inmueble;
            //Fin obtener imagenes

        } catch (Exception ex) {

        }
        return null;
    }
}
