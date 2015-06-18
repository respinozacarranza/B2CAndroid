package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.model.Inmueble;
import pe.edu.upc.b2capp.model.Usuario;

/**
 * Created by Renato on 6/12/2015.
 */
public class DetalleInmuebleFragment extends Fragment{

    // implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener
    protected SliderLayout sliderShow;
    private static final HashMap<Integer, String> inmueblesMap;
    static {
        inmueblesMap = new HashMap<Integer, String>();
        inmueblesMap.put(R.drawable.det1, "Renato tela");
        inmueblesMap.put(R.drawable.det2, "Victor tela");
        inmueblesMap.put(R.drawable.det3, "Gesek tela");
    }
    private int[] imgInmueble = {R.drawable.det1, R.drawable.det2, R.drawable.det3};
    private int mPosition;
    private ImageSwitcher imageSwitcher;
    private Button bAtras;
    private Button bAdelante;
    private Button btnMensaje;
    private Button btnLlamada;


    public DetalleInmuebleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_inmueble, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        sliderShow = (SliderLayout) getView().findViewById(R.id.slider);
        sliderShow.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        sliderShow.setDuration(6000);

        Iterator it = inmueblesMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description((String) pair.getValue())
                    .image((Integer) pair.getKey());
            sliderShow.addSlider(textSliderView);
        }


        final Inmueble inm1 = new Inmueble();
        inm1.setIdInmueble(1);
        inm1.setTitulo("VENTA DE DEPARTAMENTO EXCLUSIVO");
        inm1.setDistrito("Surco");
        inm1.setDireccion("Av primavera");
        inm1.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla a laoreet massa. Nulla lectus nisl, imperdiet sed accumsan gravida, congue vel magna. Aliquam erat volutpat.Phasellus faucibus euismod pellentesque. Quisque pellentesque est id dolor cursus condimentum.Morbi at finibus velit. Suspendisse finibus, risus vitae molestie convallis, mi odio varius sapien,sapien. Nam commodo commodo rutrum. Nullam id elit bibendum, dictum arcu sed, dapibus eros.");
        inm1.setPrecio(294000);
        inm1.setArea(135);
        inm1.setAntiguedad(2);
        inm1.setDormitorios(4);
        inm1.setBanos(2);
        inm1.setEstacionamientos(1);

        Usuario u = new Usuario();
        u.setIdUsuario(1);
        u.setTelefono("948314023");
        u.setEmail("respinozacarranza@gmail.com");

        inm1.setIdUsuario(u);

        TextView textView = (TextView)getActivity().findViewById(R.id.textViewTitulo);
        TextView textView2 = (TextView)getActivity().findViewById(R.id.textViewPrecio);
        TextView textView3 = (TextView)getActivity().findViewById(R.id.textViewArea);
        TextView textView4 = (TextView)getActivity().findViewById(R.id.textViewAntiguedad);
        TextView textView5 = (TextView)getActivity().findViewById(R.id.textViewDormitorios);
        TextView textView6 = (TextView)getActivity().findViewById(R.id.textViewBanos);
        TextView textView7 = (TextView)getActivity().findViewById(R.id.textViewEstacionamientos);
        TextView textView8 = (TextView)getActivity().findViewById(R.id.textViewDescripcion);

        textView.setText(inm1.getTitulo());
        textView2.setText("Precio: " + String.valueOf(inm1.getPrecio()));
        textView3.setText("Area: " + String.valueOf(inm1.getArea()));
        textView4.setText("Antiguedad: " + String.valueOf(inm1.getAntiguedad()));
        textView5.setText("Dormitorios: " + String.valueOf(inm1.getDormitorios()));
        textView6.setText("Baños: " + String.valueOf(inm1.getBanos()));
        textView7.setText("Estacionamientos: " + String.valueOf(inm1.getEstacionamientos()));
        textView8.setText("Descripcion: " + inm1.getDescripcion());

        final String para = u.getEmail();
        final String subject = inm1.getTitulo();
        final String message = "B2C - MESSAGE";
        final String llamada = u.getTelefono();

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
    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
