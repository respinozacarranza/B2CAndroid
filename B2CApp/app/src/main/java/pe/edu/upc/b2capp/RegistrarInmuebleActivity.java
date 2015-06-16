package pe.edu.upc.b2capp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import pe.edu.upc.b2capp.fragments.RegistrarInmuebleFragment;

/**
 * Created by Renato on 6/15/2015.
 */
public class RegistrarInmuebleActivity extends BaseActivity{
    private RegistrarInmuebleFragment fragmentos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registrar_inmueble);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentos = new RegistrarInmuebleFragment();
            fragmentTransaction.add(R.id.frame_registro_inmueble, fragmentos);
            fragmentTransaction.commit();
        }
    }



}
