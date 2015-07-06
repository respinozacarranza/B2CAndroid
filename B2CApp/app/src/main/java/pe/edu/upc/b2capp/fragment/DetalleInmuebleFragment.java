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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import at.markushi.ui.CircleButton;
import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.activity.MapaInmueblesActivity;
import pe.edu.upc.b2capp.connection.RequestQueueManager;
import pe.edu.upc.b2capp.connection.UriConstant;
import pe.edu.upc.b2capp.model.Favorito;
import pe.edu.upc.b2capp.model.ImagenSimple;
import pe.edu.upc.b2capp.model.InmuebleIn;
import pe.edu.upc.b2capp.model.TipoInmueble;
import pe.edu.upc.b2capp.model.TipoTransaccion;
import pe.edu.upc.b2capp.model.Usuario;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Renato on 6/12/2015.
 */
public class DetalleInmuebleFragment extends Fragment{

    private Integer idInmueble;
    private InmuebleIn inmueble;

    private CircleButton btnFavorito;
    private Button btnMensaje;
    private Button btnLlamada;
    private Usuario loggedUser;
    private ImageButton pruebaMandaCoord;


    public DetalleInmuebleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Activity activity = getActivity();
        Intent intent = activity.getIntent();
        loggedUser = LocalSession.getInstance(getActivity()).getLoggedUser();

        View rootView = inflater.inflate(R.layout.fragment_detalle_inmueble, container, false);
        if (intent != null && intent.hasExtra("idInmueble")) {

            idInmueble = intent.getIntExtra("idInmueble", 0);

            final ProgressDialog progressDialog =
                    ProgressDialog.show(activity, "Espere...", "Obteniendo Inmueble...");

            String uriInmueble =
                    UriConstant.URL_BASE + UriConstant.GET_INMUEBLE + idInmueble.toString();

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET, uriInmueble,
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

            if (loggedUser != null) {
                String uriFavorito =
                        UriConstant.URL_BASE + UriConstant.ES_FAVORITO
                                + "?idInmueble=" + idInmueble.toString()
                                + "&idUsuario=" + loggedUser.getIdUsuario().toString();

                JsonObjectRequest jsonObjectRequestFav = new JsonObjectRequest(
                        Request.Method.GET, uriFavorito,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Boolean esFavorito = response.getBoolean("valor");
                                    if (!esFavorito) {
                                        btnFavorito.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                agregarFavorito();
                                            }
                                        });
                                    } else {
                                        btnFavorito.setImageResource(R.drawable.ic_action_heart_accent);
                                        btnFavorito.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                eliminarFavorito();
                                            }
                                        });
                                    }
                                } catch (Exception ex) {
                                    Toast.makeText(activity, "Error en el parseo", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.cancel();
                        Toast.makeText(activity,"Error al obtener favorito", Toast.LENGTH_SHORT).show();
                    }
                });

                RequestQueueManager
                        .getInstance(activity)
                        .addToRequestQueue(jsonObjectRequestFav);
            }
        }
        return rootView;
    }

    public void agregarFavorito() {
        final Activity activity = getActivity();
        final ProgressDialog progressDialog =
                ProgressDialog.show(activity, "Espere...", "Agregando inmueble a favoritos...");

        String uriFavorito =
                UriConstant.URL_BASE + UriConstant.ADD_FAVORITO;

        Favorito f = new Favorito();
        f.setIdInmueble(idInmueble);
        f.setIdUsuario(loggedUser.getIdUsuario());

        Gson gson = new Gson();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                uriFavorito, gson.toJson(f),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            btnFavorito.setImageResource(R.drawable.ic_action_heart_accent);
                            btnFavorito.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    eliminarFavorito();
                                }
                            });
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

    public void eliminarFavorito() {
        final Activity activity = getActivity();
        final ProgressDialog progressDialog =
                ProgressDialog.show(activity, "Espere...", "Eliminando inmueble de favoritos...");

        String uriFavorito =
                UriConstant.URL_BASE + UriConstant.DELETE_FAVORITO;

        Favorito f = new Favorito();
        f.setIdInmueble(idInmueble);
        f.setIdUsuario(loggedUser.getIdUsuario());

        Gson gson = new Gson();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                uriFavorito, gson.toJson(f),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            btnFavorito.setImageResource(R.drawable.ic_action_heart_light);
                            btnFavorito.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    agregarFavorito();
                                }
                            });
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

    public void cargarInmueble(InmuebleIn inmueblein) {

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
          }

        TextView textTitulo = (TextView)getActivity().findViewById(R.id.textViewTitulo);
        TextView textPrecio = (TextView)getActivity().findViewById(R.id.textViewPrecio);
        TextView textDireccion = (TextView)getActivity().findViewById(R.id.textViewDireccion);
        TextView textDistrito = (TextView)getActivity().findViewById(R.id.textViewDistrito);
        TextView textAreaTotal = (TextView)getActivity().findViewById(R.id.textViewAreaTotal);
        TextView textAreaConstruida = (TextView)getActivity().findViewById(R.id.textViewAreaConstruida);
        TextView textTipoInmueble = (TextView)getActivity().findViewById(R.id.textViewTipoInmueble);
        TextView textTipoTransaccion = (TextView)getActivity().findViewById(R.id.textViewTipoTransaccion);
        TextView textAntiguedad = (TextView)getActivity().findViewById(R.id.textViewAntiguedad);
        TextView textDormitorios = (TextView)getActivity().findViewById(R.id.textViewDormitorios);
        TextView textBanos = (TextView)getActivity().findViewById(R.id.textViewBanos);
        TextView textDescripcion = (TextView)getActivity().findViewById(R.id.textViewDescripcion);

        textTitulo.setText(inmueblein.getTitulo());
        textPrecio.setText("Precio: S/. " + String.valueOf(inmueblein.getPrecio()));
        textDireccion.setText("Direccion: " + inmueblein.getDireccion());
        textDistrito.setText("Distrito: " + inmueblein.getDistrito());
        textAreaTotal.setText("Area total: " + String.valueOf(inmueblein.getAreaTotal()) + " m2");
        textAreaConstruida.setText("Area construida: " + String.valueOf(inmueblein.getAreaTotal()) + " m2");
        textTipoInmueble.setText("Tipo de inmueble: " + inmueblein.getTipoInmueble().getDescripcion());
        textTipoTransaccion.setText("Tipo de transaccion: " + inmueblein.getTipoTransaccion().getDescripcion());
        textAntiguedad.setText("Antiguedad: " + String.valueOf(inmueblein.getAntiguedad()) + " años");
        textDormitorios.setText("Dormitorios: " + String.valueOf(inmueblein.getDormitorios()));
        textBanos.setText("Baños: " + String.valueOf(inmueblein.getBanos()));
        textDescripcion.setText("Descripcion: " + inmueblein.getDescripcion());

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        final String para = "respinozacarranza@gmail.com";
        final String subject = "Deseo comunicarme";
        final String message = "B2C - MESSAGE";
        final String llamada = "948314023";

        btnFavorito = (CircleButton) view.findViewById(R.id.btnFavorito);

        if (loggedUser == null) {
            btnFavorito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity()
                            , "Debe iniciar sesión para marcar este inmueble como favorito"
                            , Toast.LENGTH_SHORT).show();
                }
            });
        }

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

        pruebaMandaCoord = (ImageButton)view.findViewById(R.id.btnMandarCoords);
        pruebaMandaCoord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(),MapaInmueblesActivity.class);
                Bundle b = new Bundle();
                b.putDouble("lat",inmueble.getLatitud().doubleValue());
                b.putDouble("lon",inmueble.getLatitud().doubleValue());
                i.putExtras(b);
                /*i.putExtra("lat",inmueble.getLatitud());*/
               // i.putExtra("lon",inmueble.getLongitud());

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
            inmueble.setTitulo(jsonObject.getString("titulo"));
            inmueble.setDireccion(jsonObject.getString("direccion"));
            inmueble.setAntiguedad(jsonObject.getInt("antiguedad"));
            inmueble.setAreaConstruida(BigDecimal.valueOf(jsonObject.getDouble("areaConstruida")));
            inmueble.setAreaTotal(BigDecimal.valueOf(jsonObject.getDouble("areaTotal")));
            inmueble.setBanos(jsonObject.getInt("banos"));
            inmueble.setCantidadFavoritos(BigInteger.valueOf(jsonObject.getLong("cantidadFavoritos")));
            inmueble.setDescripcion(jsonObject.getString("descripcion"));
            inmueble.setDireccion(jsonObject.getString("direccion"));
            inmueble.setDistrito(jsonObject.getString("distrito"));
            inmueble.setDormitorios(jsonObject.getInt("dormitorios"));
            inmueble.setLatitud(BigDecimal.valueOf(jsonObject.getDouble("latitud")));
            inmueble.setLongitud(BigDecimal.valueOf(jsonObject.getDouble("longitud")));
            inmueble.setPrecio(BigDecimal.valueOf(jsonObject.getDouble("precio")));

            JSONObject jsonTipoInmueble = (jsonObject.getJSONObject("tipoInmueble"));
            TipoInmueble ti = new TipoInmueble();
            ti.setIdTipoInmueble(jsonTipoInmueble.getInt("idInmueble"));
            ti.setDescripcion(jsonTipoInmueble.getString("descripcion"));
            inmueble.setTipoInmueble(ti);

            JSONObject jsonTipoTransaccion = (jsonObject.getJSONObject("tipoTransaccion"));
            TipoTransaccion tt = new TipoTransaccion();
            tt.setIdTipoTransaccion(jsonTipoTransaccion.getInt("idTipoTransaccion"));
            tt.setDescripcion(jsonTipoTransaccion.getString("descripcion"));
            inmueble.setTipoTransaccion(tt);

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
