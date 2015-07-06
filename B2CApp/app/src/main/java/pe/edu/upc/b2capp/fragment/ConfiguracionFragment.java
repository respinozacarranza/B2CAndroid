package pe.edu.upc.b2capp.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import pe.edu.upc.b2capp.R;

/**
 * Created by Vj on 05/07/2015.
 */
public class ConfiguracionFragment extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);
    }
}
