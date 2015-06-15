package pe.edu.upc.b2capp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Renato on 6/8/2015.
 */
public class PersonaFragment extends Fragment{

    public PersonaFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_persona, container, false);
    }

}
