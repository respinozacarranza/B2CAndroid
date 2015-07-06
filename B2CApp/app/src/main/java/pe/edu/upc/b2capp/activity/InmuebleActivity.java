package pe.edu.upc.b2capp.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.adapter.InmuebleAdapter;
import pe.edu.upc.b2capp.fragment.InmueblesFragment;
import pe.edu.upc.b2capp.fragment.LoginFragment;
import pe.edu.upc.b2capp.model.InmuebleSimple;
import pe.edu.upc.b2capp.model.InmuebleSimpleComparator;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Renato on 6/8/2015.
 */
public class InmuebleActivity extends NavDrawerActivity{


    private InmueblesFragment mInmuebleFragment;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inmuebles, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_ordenar_favoritos:
                Toast.makeText(this, "Favoritos", Toast.LENGTH_SHORT).show();
                ordenarListInmuebles("favoritos");
                return true;
            case R.id.menu_ordenar_fecha:
                Toast.makeText(this, "Fecha", Toast.LENGTH_SHORT).show();
                ordenarListInmuebles("fecha");
                return true;
            case R.id.menu_ordenar_precio:
                Toast.makeText(this, "Precio", Toast.LENGTH_SHORT).show();
                ordenarListInmuebles("precio");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmuebles);
        if(savedInstanceState==null)
        {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mInmuebleFragment = new InmueblesFragment();
            fragmentTransaction.add(R.id.content_fragment,mInmuebleFragment);
            fragmentTransaction.commit();
        }
    }

    private void ordenarListInmuebles(String criterio) {

        InmuebleSimpleComparator ic = new InmuebleSimpleComparator();
        InmuebleAdapter adapter = (InmuebleAdapter) mInmuebleFragment.getAdapter();
        List<InmuebleSimple> listaInmuebles = adapter.getInmuebles();

        switch (criterio.toLowerCase()) {
            case "fecha":
                break;
            case "favoritos":
                break;
            case "precio":
                break;
        }
        Collections.sort(listaInmuebles, ic);
        adapter.setInmuebles(listaInmuebles);
        adapter.notifyDataSetChanged();
    }
}
