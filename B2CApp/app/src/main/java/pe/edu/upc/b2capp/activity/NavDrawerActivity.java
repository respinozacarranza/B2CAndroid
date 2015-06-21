package pe.edu.upc.b2capp.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.model.Usuario;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Jose on 17/06/2015.
 */
public class NavDrawerActivity extends BaseActivity {
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_nav_drawer);
    }

    @Override
    public void setContentView(int layoutResView) {
        ViewGroup content = (ViewGroup) findViewById(R.id.nav_drawer_activity_container);
        getLayoutInflater().inflate(layoutResView, content);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // Si la pantalla rota, actualiza el estado
        mDrawerToggle.syncState();
    }

    private void addDrawerItems() {
        String[] osArray = { "Mis inmuebles", "Favoritos", "Crear inmueble", "Cerca de mí", "Perfil"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivityPos(position);
            }
        });
    }

    protected void startActivityPos(int pos) {
        Intent intent;
        switch (pos) {
            case 0://Mis inmuebles
                //TODO Implementar Mis inmuebles
                Toast.makeText(NavDrawerActivity.this, "Falta implementar", Toast.LENGTH_SHORT).show();
                break;
            case 1://Favoritos
                intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                break;
            case 2://Crear Inmueble
                intent = new Intent(this, RegistrarInmuebleActivity.class);
                startActivity(intent);
                break;
            case 3://Cerca de mi
                //TODO Implementar Mis inmuebles
                Toast.makeText(NavDrawerActivity.this, "Falta implementar", Toast.LENGTH_SHORT).show();
                break;
            case 4://Perfil
                //TODO Implementar Mis inmuebles
                LocalSession localSession = LocalSession.getInstance(this);
                Usuario nuevouser = localSession.getLoggedUser();

                if(nuevouser == null)
                {
                    Toast.makeText(NavDrawerActivity.this, "Debe estar conectado", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent = new Intent(this, ModificarUsuarioActivity.class);
                    startActivity(intent);
                }
                //Toast.makeText(NavDrawerActivity.this, "Falta implementar", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navegación");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
