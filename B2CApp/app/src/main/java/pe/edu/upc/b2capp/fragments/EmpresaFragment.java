package pe.edu.upc.b2capp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.b2capp.R;

/**
 * Created by Renato on 6/8/2015.
 */
public class EmpresaFragment extends Fragment{

    public EmpresaFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_empresa, container,false);
    }
}
