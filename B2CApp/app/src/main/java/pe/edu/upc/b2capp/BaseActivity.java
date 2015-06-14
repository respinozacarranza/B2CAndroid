package pe.edu.upc.b2capp;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends ActionBarActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_creados:
                //menu creados
                return true;
            case R.id.menu_favoritos:
                //menu favoritos
                return true;
            case R.id.menu_perfil:
                //menu favoritos
                return true;
            case R.id.menu_configuracion:
                //menu favoritos
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
