package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.activity.DetalleInmuebleActivity;
import pe.edu.upc.b2capp.adapter.InmuebleAdapter;
import pe.edu.upc.b2capp.connection.UriConstant;
import pe.edu.upc.b2capp.model.InmuebleSimple;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Renato on 6/8/2015.
 */
public class InmueblesFragment extends Fragment{

    private ArrayList<InmuebleSimple> dataset;
    private ListView listView;
    private BaseAdapter adapter;
    private String URL_INMUEBLES;
    //FavoritosAdapter mFavoritosAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inmuebles, container, false);
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("URL")) {
            URL_INMUEBLES = intent.getStringExtra("URL");
        }
        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView)getActivity().findViewById(R.id.listView_inmuebles);
        adapter = new InmuebleAdapter(getActivity(), URL_INMUEBLES);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getActivity();
                InmuebleSimple inmuebleSimple = (InmuebleSimple)adapter.getItem(position);

                Intent intent = new Intent(context, DetalleInmuebleActivity.class)
                        .putExtra("idInmueble", inmuebleSimple.getId());
                startActivity(intent);
            }
        });
    }

}
