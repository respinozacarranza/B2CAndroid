package pe.edu.upc.b2capp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.model.InmuebleSimple;

/**
 * Created by Renato on 6/8/2015.
 */
public class FavoritosAdapter extends BaseAdapter{

    private List<InmuebleSimple> favoritos;
    private Context context;

    public FavoritosAdapter(List<InmuebleSimple> favoritos, Context context){
        this.favoritos = favoritos;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (favoritos != null)
            return favoritos.size();
        else return 0;
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

        TextView t4 = (TextView)convertView.findViewById(R.id.textViewPrecio);

        InmuebleSimple inmuebleSimple = favoritos.get(position);

        t1.setText(inmuebleSimple.getTitulo());
        t2.setText(inmuebleSimple.getDireccion());
        t3.setText(inmuebleSimple.getTipoTransaccion());
        t4.setText(inmuebleSimple.getPrecio().toString());
        return convertView;



    }

}
