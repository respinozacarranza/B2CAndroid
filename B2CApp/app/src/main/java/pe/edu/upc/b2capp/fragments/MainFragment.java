package pe.edu.upc.b2capp.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pe.edu.upc.b2capp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment  {


    Button button_conectarse;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedBundlesState){

        button_conectarse = (Button) view.findViewById(R.id.)

    }






}
