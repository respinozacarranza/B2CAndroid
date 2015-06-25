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
public class ModificarEmpresaFragment extends Fragment {

    private UserManager userManager;
    Usuario nuevo_user;
    EditText mEditTextRazonSocial;
    EditText mEditTextEmail;
    EditText mEditTextRUC;
    EditText mEditTextDireccion;
    EditText mEditTextWeb;
    EditText mEditTextUsuario;
    EditText mEditTextContrasena;
    Button mButtonRegistrar;

    public ModificarEmpresaFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_modificar_empresa,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedBundlesState){

        userManager = UserManager.getInstance(getActivity());

        LocalSession localSession = LocalSession.getInstance(getActivity());
        final Usuario currentuser = localSession.getLoggedUser();

        mEditTextRazonSocial = (EditText) view.findViewById(R.id.ModEmp_et_RazonSocial);
        mEditTextRazonSocial.setText(currentuser.getNombre().toString());

        mEditTextEmail = (EditText) view.findViewById(R.id.ModEmp_et_Email);
        mEditTextEmail.setText(currentuser.getEmail().toString());

        mEditTextRUC = (EditText) view.findViewById(R.id.ModEmp_et_RUC);
        mEditTextRUC.setText(currentuser.getRuc().toString());

        mEditTextDireccion = (EditText) view.findViewById(R.id.ModEmp_et_Direccion);
        mEditTextDireccion.setText(currentuser.getRuc().toString());

        mEditTextWeb = (EditText) view.findViewById(R.id.ModEmp_et_Web);
        mEditTextWeb.setText(currentuser.getWeb().toString());

        mEditTextUsuario = (EditText) view.findViewById(R.id.ModUser_et_usuario);
        mEditTextUsuario.setText(currentuser.getUsuario().toString());

        mButtonRegistrar = (Button) view.findViewById(R.id.ModUser_btn_mod);

        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevo_user = new Usuario();
                nuevo_user.setIdUsuario(currentuser.getIdUsuario());
                nuevo_user.setNombre(mEditTextRazonSocial.getText().toString());
                nuevo_user.setRuc(mEditTextRUC.getText().toString());
                nuevo_user.setDireccion(mEditTextDireccion.getText().toString());
                nuevo_user.setWeb(mEditTextWeb.getText().toString());
                nuevo_user.setEmail(mEditTextEmail.getText().toString());
                nuevo_user.setUsuario(mEditTextUsuario.getText().toString());
                //nuevo_user.setPassword(mEditTextContrasena.getText().toString());
                nuevo_user.setIdTipoUsuario(2);

                userManager.ModificarUsuario(nuevo_user,getActivity());
            }
        });

    }

}
