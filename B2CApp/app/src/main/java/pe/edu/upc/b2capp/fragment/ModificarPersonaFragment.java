package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.connection.UserManager;
import pe.edu.upc.b2capp.model.Usuario;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Andres on 20/06/2015.
 */
public class ModificarPersonaFragment extends Fragment {

    private UserManager userManager;
    Usuario nuevo_user;
    EditText mEditTextNombre;
    EditText mEditTextEmail;
    EditText mEditTextUsuario;
    EditText mEditTextContrasena;
    Button mButtonRegistrar;

    public  ModificarPersonaFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_modificar_persona, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedBundlesState){

        userManager = UserManager.getInstance(getActivity());

        LocalSession localSession = LocalSession.getInstance(getActivity());
        final Usuario currentuser = localSession.getLoggedUser();

        mEditTextNombre = (EditText) view.findViewById(R.id.ModUser_et_nombre);
        mEditTextNombre.setText(currentuser.getNombre().toString());

        mEditTextEmail = (EditText) view.findViewById(R.id.ModUser_et_email);
        mEditTextEmail.setText(currentuser.getEmail().toString());

        mEditTextUsuario = (EditText) view.findViewById(R.id.ModUser_et_usuario);
        mEditTextUsuario.setText(currentuser.getUsuario().toString());

        mButtonRegistrar = (Button) view.findViewById(R.id.ModUser_btn_mod);

        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevo_user = new Usuario();
                nuevo_user.setIdUsuario(currentuser.getIdUsuario());
                nuevo_user.setNombre(mEditTextNombre.getText().toString());
                nuevo_user.setEmail(mEditTextEmail.getText().toString());
                nuevo_user.setUsuario(mEditTextUsuario.getText().toString());
                //nuevo_user.setPassword(mEditTextContrasena.getText().toString());
                nuevo_user.setIdTipoUsuario(1);

                userManager.ModificarUsuario(nuevo_user,getActivity());
            }
        });

    }

}
