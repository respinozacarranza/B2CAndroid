package pe.edu.upc.b2capp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.connection.UriConstant;
import pe.edu.upc.b2capp.fragment.MainFragment;
import pe.edu.upc.b2capp.model.Usuario;
import pe.edu.upc.b2capp.session.LocalSession;


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
        PreferenceManager.setDefaultValues(this, R.xml.preference, false);
    }

    public void favoritos(View view){
        Usuario usuario = LocalSession.getInstance(this).getLoggedUser();
        if (usuario == null) {
            Toast.makeText(this, "Sesión no iniciada", Toast.LENGTH_SHORT).show();
        } else {

            Intent intent = new Intent(this, InmuebleActivity.class)
                    .putExtra("URL", UriConstant.URL_BASE +
                                    UriConstant.GET_FAVORITOS +
                                    usuario.getIdUsuario().toString());
            startActivity(intent);
        }
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
