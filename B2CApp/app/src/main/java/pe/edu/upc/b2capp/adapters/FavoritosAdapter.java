package pe.edu.upc.b2capp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.models.Favorito;

/**
 * Created by Renato on 6/8/2015.
 */
public class FavoritosAdapter extends BaseAdapter{

    private List<Favorito> favoritos;
    private Context context;

    public FavoritosAdapter(List<Favorito> libros, Context context){
        this.favoritos = favoritos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return favoritos.size();
    }

    @Override
    public Object getItem(int position) {
        return favoritos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.row_favoritos,null);
        }

        TextView t1 = (TextView)convertView.findViewById(R.id.textViewL);
        TextView t2 = (TextView)convertView.findViewById(R.id.textViewS);
        TextView t3 = (TextView)convertView.findViewById(R.id.textViewM);

        Favorito favorito = favoritos.get(position);

        t1.setText(favorito.getIdInmueble().getDistrito());
        t1.setText(favorito.getIdInmueble().getDescripcion());
        t1.setText(favorito.getIdInmueble().getDireccion());

        return convertView;



    }

}
