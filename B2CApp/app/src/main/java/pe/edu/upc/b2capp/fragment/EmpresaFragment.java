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
public class EmpresaFragment extends Fragment{

    private UserManager userManager;
    Usuario nuevo_empresa;
    EditText mEditTextRazonSocial;
    EditText mbEditTextEmail;
    EditText mbEditTextRUC;
    EditText mbEditTextDireccion;
    EditText mbEditTextWeb;
    EditText mbEditTextUsuario;
    EditText mbEditTextContrasena;
    Button mButtonRegistrate;
    Pattern pattern;
    Matcher matcher;

    public EmpresaFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_empresa, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedBundleState){
        userManager = UserManager.getInstance(getActivity());
        mEditTextRazonSocial = (EditText) view.findViewById(R.id.RegEmp_et_RazonSocial);
        mbEditTextEmail = (EditText) view.findViewById(R.id.RegEmp_et_Email);
        mbEditTextRUC = (EditText) view.findViewById(R.id.RegEmp_et_RUC);
        mbEditTextDireccion = (EditText) view.findViewById(R.id.RegEmp_et_Direccion);
        mbEditTextWeb = (EditText) view.findViewById(R.id.RegEmp_et_Web);
        mbEditTextUsuario = (EditText) view.findViewById(R.id.RegEmp_et_Usuario);
        mbEditTextContrasena = (EditText) view.findViewById(R.id.RegEmp_et_Contrasena);
        mButtonRegistrate = (Button) view.findViewById(R.id.RegEmp_btn_Registrate);

        mButtonRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String razonSocial = mEditTextRazonSocial.getText().toString();
                final String email = mbEditTextEmail.getText().toString();
                final String ruc = mbEditTextRUC.getText().toString();
                final String direccion = mbEditTextDireccion.getText().toString();
                final String web = mbEditTextWeb.getText().toString();
                final String usuario = mbEditTextUsuario.getText().toString();
                final String contrasena = mbEditTextContrasena.getText().toString();


                if(razonSocial.length()==0){
                    mEditTextRazonSocial.requestFocus();
                    mEditTextRazonSocial.setError("EL CAMPO NO PUEDE ESTAR VACIO");

                }
                if(ruc.length()!=10){
                    mbEditTextRUC.requestFocus();
                    mbEditTextRUC.setError("EL RUC ES INCORRECTO");
                }
                if(direccion.length()==0){
                    mbEditTextDireccion.requestFocus();
                    mbEditTextDireccion.setError("EL CAMPO NO PUEDE ESTAR VACIO");
                }
                if(web.length()==0){
                    mbEditTextWeb.requestFocus();
                    mbEditTextWeb.setError("EL CAMPO NO PUEDE ESTAR VACIO");
                }
                if(usuario.length()==0){
                    mbEditTextUsuario.requestFocus();
                    mbEditTextUsuario.setError("EL CAMPO NO PUEDE ESTAR VACIO");
                }
                if(contrasena.length()==0){
                    mbEditTextContrasena.requestFocus();
                    mbEditTextContrasena.setError("EL CAMPO NO PUEDE ESTAR VACIO");
                }
                if(!esEmailValido(email)){
                    mbEditTextEmail.requestFocus();
                    mbEditTextEmail.setError("NO ES UN EMAIL VALIDO");
                }
                else{

                    nuevo_empresa = new Usuario();
                    nuevo_empresa.setIdUsuario(null);
                    nuevo_empresa.setNombre(mEditTextRazonSocial.getText().toString());
                    nuevo_empresa.setEmail(mbEditTextEmail.getText().toString());
                    nuevo_empresa.setRuc(mbEditTextRUC.getText().toString());
                    nuevo_empresa.setDireccion(mbEditTextDireccion.getText().toString());
                    nuevo_empresa.setWeb(mbEditTextWeb.getText().toString());
                    nuevo_empresa.setUsuario(mbEditTextUsuario.getText().toString());
                    nuevo_empresa.setPassword(mbEditTextContrasena.getText().toString());
                    nuevo_empresa.setIdTipoUsuario(2);

                    userManager.RegistrarUsuario(nuevo_empresa,getActivity());
                }

            }
        });

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

        pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }
}
