package pe.edu.upc.b2capp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.fragment.ModificarEmpresaFragment;
import pe.edu.upc.b2capp.fragment.ModificarPersonaFragment;
import pe.edu.upc.b2capp.model.Usuario;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Andres on 20/06/2015.
 */
public class ModificarUsuarioActivity extends AppCompatActivity {

    private ModificarPersonaFragment modificarPersonaFragment;
    private ModificarEmpresaFragment modificarEmpresaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        LocalSession localSession = LocalSession.getInstance(this);
        Usuario nuevouser = localSession.getLoggedUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_usuario);

        if (savedInstanceState == null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if(nuevouser.getIdTipoUsuario()==1){
                modificarPersonaFragment = new ModificarPersonaFragment();
                fragmentTransaction.add(R.id.content_fragment_modificar_usuario,modificarPersonaFragment);
                fragmentTransaction.commit();
            }
            if (nuevouser.getIdTipoUsuario()==2){
                modificarEmpresaFragment = new ModificarEmpresaFragment();
                fragmentTransaction.add(R.id.content_fragment_modificar_usuario,modificarEmpresaFragment);
                fragmentTransaction.commit();
            }
        }

    }
}
