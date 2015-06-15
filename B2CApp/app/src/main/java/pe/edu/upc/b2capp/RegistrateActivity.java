package pe.edu.upc.b2capp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import pe.edu.upc.b2capp.fragments.PersonaFragment;

/**
 * Created by Andres on 15/06/2015.
 */
public class RegistrateActivity extends ActionBarActivity {

    private PersonaFragment personaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        if (savedInstanceState == null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            personaFragment = new PersonaFragment();
            fragmentTransaction.add(R.id.content_fragment,personaFragment);
            fragmentTransaction.commit();
        }
    }
}
