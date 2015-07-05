package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.connection.UserManager;
import pe.edu.upc.b2capp.model.Usuario;

/**
 * Created by Renato on 6/8/2015.
 */
public class PersonaFragment extends Fragment{

    private UserManager userManager;
    Usuario nuevo_user;
    EditText mEditTextNombre;
    EditText mEditTextEmail;
    EditText mEditTextUsuario;
    EditText mEditTextContrasena;
    Button mButtonRegistrar;
    Pattern pattern;
    Matcher matcher;

    public PersonaFragment(){

    }

    public boolean esEmailValido(String email)
    {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_persona, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedBundlesState){
        userManager = UserManager.getInstance(getActivity());
        mEditTextNombre = (EditText) view.findViewById(R.id.RegUser_et_nombre);
        mEditTextEmail = (EditText) view.findViewById(R.id.RegUser_et_email);
        mEditTextUsuario = (EditText) view.findViewById(R.id.RegUser_et_usuario);
        mEditTextContrasena = (EditText) view.findViewById(R.id.RegUser_et_contrasena);
        mButtonRegistrar = (Button) view.findViewById(R.id.RegUser_btn_reg);

        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nombre = mEditTextNombre.getText().toString();
                final String email = mEditTextEmail.getText().toString();
                final String usuario = mEditTextUsuario.getText().toString();
                final String password = mEditTextContrasena.getText().toString();
                if(nombre.length() ==0){

                    mEditTextNombre.requestFocus();
                    mEditTextNombre.setError("EL CAMPO NO PUEDE ESTAR VACIO");

                }
                if(usuario.length() ==0){

                    mEditTextUsuario.requestFocus();
                    mEditTextUsuario.setError("EL CAMPO NO PUEDE ESTAR VACIO");

                }
                if(password.length() ==0){

                    mEditTextContrasena.requestFocus();
                    mEditTextContrasena.setError("EL CAMPO NO PUEDE ESTAR VACIO");

                }
                if(!esEmailValido(email)){
                    mEditTextEmail.requestFocus();
                    mEditTextEmail.setError("NO ES UN EMAIL VALIDO");

                }
                else{
                    nuevo_user = new Usuario();
                    nuevo_user.setIdUsuario(null);
                    nuevo_user.setNombre(mEditTextNombre.getText().toString());
                    nuevo_user.setEmail(mEditTextEmail.getText().toString());
                    nuevo_user.setUsuario(mEditTextUsuario.getText().toString());
                    nuevo_user.setPassword(mEditTextContrasena.getText().toString());
                    nuevo_user.setIdTipoUsuario(1);

                    userManager.RegistrarUsuario(nuevo_user,getActivity());
                }





            }
        });


    }

}
