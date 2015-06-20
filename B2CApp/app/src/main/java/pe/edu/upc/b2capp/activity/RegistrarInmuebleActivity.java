package pe.edu.upc.b2capp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.fragment.RegistrarInmuebleFragment;

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
