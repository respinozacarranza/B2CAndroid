package pe.edu.upc.b2capp.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import pe.edu.upc.b2capp.activity.LoginActivity;
import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.activity.RegistrarUsuarioActivity;
import pe.edu.upc.b2capp.model.Usuario;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment  {


    private Button mButtonConectarse;
    private Button mButtonRegistrate;
    //private ImageButton mButtonRegistrarInmueble;
    private TextView mTextViewUsername;
    private LocalSession localSession;

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

        localSession = LocalSession.getInstance(getActivity());
        mButtonConectarse = (Button) view.findViewById(R.id.conect);
        mButtonRegistrate = (Button) view.findViewById(R.id.reg);
        mTextViewUsername = (TextView) view.findViewById(R.id.main_tv_username);
        //mButtonRegistrarInmueble = (ImageButton)view.findViewById(R.id.imageButton);

        /*mButtonRegistrarInmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegistrarInmuebleActivity.class);
                startActivity(intent);
            }
        });*/

        mButtonConectarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        mButtonRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegistrarUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Usuario u = localSession.getLoggedUser();

        if (u != null) {
            mTextViewUsername.setText("Bienvenido, " + u.getNombre());
            mButtonConectarse.setVisibility(View.GONE);
            mButtonRegistrate.setVisibility(View.GONE);
        }
        else {
            mTextViewUsername.setText("");
            mButtonConectarse.setVisibility(View.VISIBLE);
            mButtonRegistrate.setVisibility(View.VISIBLE);

        }
    }
}
