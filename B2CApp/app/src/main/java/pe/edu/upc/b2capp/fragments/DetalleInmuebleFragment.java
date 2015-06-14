package pe.edu.upc.b2capp.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.adapters.TransformerAdapter;
import pe.edu.upc.b2capp.models.Inmueble;

/**
 * Created by Renato on 6/12/2015.
 */
public class DetalleInmuebleFragment extends Fragment{

    // implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener
    private int[] imgInmueble = {R.drawable.det1, R.drawable.det2, R.drawable.det3};
    private int mPosition;
    private ImageSwitcher imageSwitcher;
    private Button bAtras;
    private Button bAdelante;


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
        mPosition = 1;

        bAtras = (Button)view.findViewById(R.id.btnAtras);

        bAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSwitch2(view);
            }
        });

        bAdelante = (Button)view.findViewById(R.id.btnAdelante);

        bAdelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSwitch(view);
            }
        });

        mPosition = 0;
        imageSwitcher = (ImageSwitcher)getActivity().findViewById(R.id.galeriaInmueble);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getActivity());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        imageSwitcher.setInAnimation(getActivity(), R.anim.abc_slide_in_top);
        imageSwitcher.setOutAnimation(getActivity(), R.anim.abc_slide_out_bottom);

        Inmueble inm1 = new Inmueble();
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
        textView4.setText("Antiguedad" + String.valueOf(inm1.getAntiguedad()));
        textView5.setText("Dormitorios: " + String.valueOf(inm1.getDormitorios()));
        textView6.setText("Baños: " + String.valueOf(inm1.getBanos()));
        textView7.setText("Estacionamientos: " + String.valueOf(inm1.getEstacionamientos()));
        textView8.setText("Descripcion: " + inm1.getDescripcion());











    }


    public void onSwitch(View view){
        if(mPosition<2) {
            imageSwitcher.setBackgroundResource(imgInmueble[mPosition]);
            // mPosition++;
            mPosition = (mPosition + 1);
        }
    }

    public void onSwitch2(View view){
        if(mPosition>0){
            imageSwitcher.setBackgroundResource(imgInmueble[mPosition]);

            //mPosition--;
            mPosition = (mPosition - 1);
        }

    }



    /*@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDemoSlider = (SliderLayout)getActivity().findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Sala",R.drawable.det1);
        file_maps.put("Comedor",R.drawable.det2);
        file_maps.put("Dormitorio",R.drawable.det3);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());



            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);


            textSliderView.getBundle()
                    .putString("extra",name);
            mDemoSlider.addSlider(textSliderView);

        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


    }*/

    /*@Override
    public void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();

    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {

        Log.d("Slider Demo", "Page Changed: " + i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {


    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {

    }*/


}
