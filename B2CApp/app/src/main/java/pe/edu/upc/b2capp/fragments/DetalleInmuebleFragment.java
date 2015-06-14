package pe.edu.upc.b2capp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.adapters.TransformerAdapter;

/**
 * Created by Renato on 6/12/2015.
 */
public class DetalleInmuebleFragment extends Fragment{

    // implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener
    private int[] imgInmueble = {R.drawable.det1, R.drawable.det2, R.drawable.det3};
    private int mPosition;
    private ImageSwitcher imageSwitcher;

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPosition = 0;
        imageSwitcher = (ImageSwitcher)getActivity().findViewById(R.id.galeriaInmueble);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getActivity());
                return imageView;
            }
        });

        imageSwitcher.setInAnimation(getActivity(), R.anim.abc_slide_in_top);
        imageSwitcher.setOutAnimation(getActivity(), R.anim.abc_slide_out_bottom);


    }

    public void onSwitch(View view){
        if(mPosition<9) {
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
