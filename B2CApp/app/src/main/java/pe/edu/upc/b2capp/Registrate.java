package pe.edu.upc.b2capp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pe.edu.upc.b2capp.fragments.EmpresaFragment;
import pe.edu.upc.b2capp.fragments.PersonaFragment;

/**
 * Created by Renato on 6/8/2015.
 */
public class Registrate extends Activity implements ActionBar.TabListener{

    private Fragment[] fragments = new Fragment[]{
            new PersonaFragment(),
            new EmpresaFragment(),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        setTabs();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        for (Fragment fragment : fragments){
            fragmentTransaction.add(R.id.mainRegistro, fragment).hide(fragment);
        }

        fragmentTransaction.show( fragments[0]).commit();

    }

    private void setTabs(){
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("PERSONA").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("EMPRESA").setTabListener(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        for (Fragment fragment : fragments){
            fragmentTransaction.hide(fragment);
        }

        fragmentTransaction.show(fragments[tab.getPosition()]);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
