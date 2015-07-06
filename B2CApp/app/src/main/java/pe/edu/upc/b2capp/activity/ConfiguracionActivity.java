package pe.edu.upc.b2capp.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.fragment.ConfiguracionFragment;

/**
 * Created by Vj on 05/07/2015.
 */
public class ConfiguracionActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    public static final String RADIO_BUSQUEDA = "radioBusqueda";

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new ConfiguracionFragment()).commit();
        //SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
       // String syncConnPref = sharedPref.getString(SettingsActivity.KEY_PREF_SYNC_CONN, "");
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(RADIO_BUSQUEDA)) {
            Preference connectionPref = findPreference(key);
            // Set summary to be the user-description for the selected value
            connectionPref.setSummary(sharedPreferences.getString(key, ""));
        }
    }
}
/*
public class ConfiguracionActivity extends PreferenceActivity{
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
*/
