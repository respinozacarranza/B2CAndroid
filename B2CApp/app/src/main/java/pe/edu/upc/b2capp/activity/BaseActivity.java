package pe.edu.upc.b2capp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.session.LocalSession;

public class BaseActivity extends AppCompatActivity {

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
            case R.id.menu_configuracion:
                //menu favoritos
                Toast.makeText(this, "Configuracion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( this , ConfiguracionActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_cerrar_sesion:
                LocalSession ls = LocalSession.getInstance(this);
                if (ls.sessionStarted()) {
                    LocalSession.getInstance(this).closeSession(this);
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(this, "Sesión no iniciada", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
