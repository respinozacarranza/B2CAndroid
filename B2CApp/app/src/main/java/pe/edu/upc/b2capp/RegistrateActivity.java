package pe.edu.upc.b2capp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import pe.edu.upc.b2capp.fragments.EmpresaFragment;
import pe.edu.upc.b2capp.fragments.PersonaFragment;

/**
 * Created by Andres on 15/06/2015.
 */
public class RegistrateActivity extends ActionBarActivity {

    private PersonaFragment personaFragment;
    private EmpresaFragment empresaFragment;
    private Button btnEmpresa;
    private Button btnPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        if (savedInstanceState == null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            personaFragment = new PersonaFragment();
            empresaFragment = new EmpresaFragment();
            fragmentTransaction.add(R.id.content_fragment_registrate, personaFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onStart(){

        super.onStart();

        btnEmpresa = (Button)findViewById(R.id.btnEmpresa);
        btnPersona = (Button)findViewById(R.id.btnPersona);


        btnPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_fragment_registrate, personaFragment);
                ft.commit();
            }
        });


        btnEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_fragment_registrate, empresaFragment);
                ft.commit();
            }
        });
    }
}
