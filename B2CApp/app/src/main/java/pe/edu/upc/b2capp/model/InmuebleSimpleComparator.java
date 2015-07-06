package pe.edu.upc.b2capp.model;

import java.util.Comparator;

/**
 * Created by jose on 05/07/2015.
 */
public class InmuebleSimpleComparator implements Comparator<InmuebleSimple> {

    public enum Order { FECHA, FAVORITOS, PRECIO}

    private Order ordenarPor = Order.FECHA;

    public Order getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(Order ordenarPor) {
        this.ordenarPor = ordenarPor;
    }
    @Override
    public int compare(InmuebleSimple lhs, InmuebleSimple rhs) {
        int resultado = 0;
        switch(this.ordenarPor) {
            case FECHA:
                resultado = rhs.getFecha().compareTo(lhs.getFecha());
                break;
            case FAVORITOS:
                resultado = rhs.getFavoritos().compareTo(lhs.getFavoritos());
                break;
            case PRECIO:
                resultado = lhs.getPrecio().compareTo(rhs.getPrecio());
                break;
            default:

        }
        return resultado;
    }
}
