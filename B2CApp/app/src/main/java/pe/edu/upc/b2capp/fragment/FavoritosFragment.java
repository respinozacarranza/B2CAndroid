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
import pe.edu.upc.b2capp.model.InmuebleSimple;

/**
 * Created by Renato on 6/8/2015.
 */
public class FavoritosFragment extends Fragment{

    ArrayList<InmuebleSimple> dataset;
    ListView listView;
    BaseAdapter adapter;
    //FavoritosAdapter mFavoritosAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favoritos, container, false);
        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)getActivity().findViewById(R.id.listView_favoritos);
        adapter = new InmuebleAdapter(getActivity(), "http://192.168.1.41:8080/B2CWS/favoritos/1");
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
