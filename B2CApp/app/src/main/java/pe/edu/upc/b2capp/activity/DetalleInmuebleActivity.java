package pe.edu.upc.b2capp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.fragment.DetalleInmuebleFragment;

/**
 * Created by Renato on 6/13/2015.
 */
public class DetalleInmuebleActivity extends NavDrawerActivity {
    private DetalleInmuebleFragment fragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_inmueble);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmento = new DetalleInmuebleFragment();
            fragmentTransaction.add(R.id.fragment_content, fragmento);
            fragmentTransaction.commit();
        }

    }



}
