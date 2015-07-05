package pe.edu.upc.b2capp.activity;

import android.os.Bundle;
import android.view.Menu;

import pe.edu.upc.b2capp.R;

/**
 * Created by Renato on 6/8/2015.
 */
public class InmuebleActivity extends NavDrawerActivity{


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favoritos, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmuebles);
    }
}
