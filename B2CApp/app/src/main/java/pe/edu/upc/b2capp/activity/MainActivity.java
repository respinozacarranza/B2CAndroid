package pe.edu.upc.b2capp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.fragment.MainFragment;


public class MainActivity extends NavDrawerActivity{

    private MainFragment mainFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mainFragment = new MainFragment();
            fragmentTransaction.add(R.id.content_fragment, mainFragment);
            fragmentTransaction.commit();
        }
    }

    public void favoritos(View view){
        Intent intent = new Intent(this, FavoritosActivity.class);
        startActivity(intent);
    }

    public void prueba(View view){
        Intent intent = new Intent(this, MapaInmueblesActivity.class);
        startActivity(intent);
        /*Intent intent = new Intent(this, DetalleInmuebleActivity.class);
        startActivity(intent);*/
    }

    public void registro(View view){
        Intent intent = new Intent(this, RegistrarInmuebleActivity.class);
        startActivity(intent);
    }
}
