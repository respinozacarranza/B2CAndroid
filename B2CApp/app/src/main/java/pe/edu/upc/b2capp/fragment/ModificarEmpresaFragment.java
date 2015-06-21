package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.b2capp.R;

/**
 * Created by Andres on 20/06/2015.
 */
public class ModificarEmpresaFragment extends Fragment {

    public ModificarEmpresaFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_modificar_empresa,container, false);
    }

}
